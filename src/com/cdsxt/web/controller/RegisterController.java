package com.cdsxt.web.controller;

import com.cdsxt.po.Talker;
import com.cdsxt.service.TalkerService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * 处理注册逻辑
 */

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private TalkerService talkerService;

    @RequestMapping(value = {"", "register"}, method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "testify", method = RequestMethod.POST)
    public String testify(HttpServletRequest request, @Validated @ModelAttribute("returnTalker") Talker talker,
                          BindingResult result, MultipartFile icon, Model model) {
        // 必须验证 date 否则出错
        if (result.hasErrors()) {
            return "register";
        }
        // 验证无误, 检查是否存在用户名重复
        if (Objects.nonNull(this.talkerService.queryByName(talker.getName()))) {
            // 不为空, 表示存在该用户
            model.addAttribute("tip", "该用户已经存在");
            // 返回重新注册
            return "register";
        }
        // 保存用户头像到 web-inf/icons 文件夹下
        // 如果未上传头像, 需要使用默认头像; 使用到头像时, 如果数据库中该字段为 null, 则使用默认头像
        if (StringUtils.hasText(icon.getOriginalFilename())) {
            // 用户上传图片
            Long temp = new Date().getTime();
            String iconPath = "/WEB-INF/resources/icons/" + temp + icon.getOriginalFilename();
            String path = request.getServletContext().getRealPath("/WEB-INF/resources/icons");
            try {
                FileUtils.copyToFile(icon.getInputStream(), new File(path + "/" + temp + icon.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            talker.setIconPath(iconPath);
        }
        // 保存到数据库中
        this.talkerService.add(talker);
        // 验证通过, 则保存到数据库中, 并重定向到到登陆页面
        return "redirect:/wechat/login";

    }
}
