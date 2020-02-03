/**
 * title: BrowserProperties.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.constant.bean;

import com.gackey.medicine.constant.enumerate.LoginType;

/**
 * @desc TODO
 * @className BrowserProperties
 * @author gackey
 * @date 2020-01-24 16:05
 */
public class BrowserProperties {

    private String loginPage = "/login.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

}
