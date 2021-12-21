package com.pjj.domain;

/**
 * @author 潘俊杰
 * @date 2021年06月06日 10:46
 */
public class User {
    private Integer id;
    private String loginName;
    private String loginpwd;
    private String realName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "用户：[" + "id=" + id + ", 用户名='" + loginName + '\'' +
                ", 密码='" + loginpwd + '\'' +
                ", 姓名='" + realName + '\'' +
                ']';
    }
}
