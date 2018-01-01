package com.cdsxt.po;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "test_talker")
public class Talker {

    @Id
    @SequenceGenerator(name = "talkerGen", sequenceName = "seq_test_talker")
    @GeneratedValue(generator = "talkerGen")
    private Integer tid;

    @NotEmpty(message = "用户名不能为空")
    @Column(unique = true)
    private String name;

    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;

    // @NotEmpty(message = "日期不能为空") // 日期不能由 Length 进行注解
    // 因为 @NotEmpty 中包含有 @Size 验证, 也不能用于 Date 类型
    // 因为转换器中定义: 如果为 "" 则转换为 null, 所以可以使用 @NotNull 进行注解
    @NotNull(message = "生日不能为空")
    @Past
    private Date birthday;

    private byte sex;

    // 一个用户有多个好友
    @OneToMany(mappedBy = "talker")
    private Set<Friend> friends = new HashSet<>();

    private String iconPath;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public String toString() {
        return "Talker{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }
}
