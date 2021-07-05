package com.meiya.springcloudstudy.system.bean.dto;

import javax.validation.constraints.NotBlank;

public class SystemUserInfoDto {

    private String id;

    @NotBlank(message = "用户名不能为空!")
    private String userName;

    @NotBlank(message = "密码不能为空!")
    private String passWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
