package com.cdsxt.web.controller;

import com.cdsxt.po.Talker;
import com.cdsxt.service.TalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

/**
 * 处理登陆逻辑
 */

@Controller
@RequestMapping("wechat")
public class LoginController {

    @Autowired
    private TalkerService talkerService;

    @RequestMapping(value = {"", "index", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "testify", method = RequestMethod.POST)
    public String testify(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        // todo 需要验证参数是否为空

        // 根据用户名查询; 用户名唯一
        Talker talker = this.talkerService.queryByName(name);
        if (Objects.isNull(talker)) {
            // 未查询到, 则返回提示信息
            model.addAttribute("tipToName", "该用户不存在, 请检查输入");
            model.addAttribute("name", name);
            return "login";
        } else {
            // 查询到, 再检查密码是否正确
            if (talker.getPassword().equals(password)) {
                // 密码正确
                model.addAttribute("talker", talker);
                return "main";
            } else {
                // 密码不正确
                model.addAttribute("tipToPassword", "密码不正确, 请检查输入");
                model.addAttribute("name", talker.getName());
                return "login";
            }
        }

    }
}
