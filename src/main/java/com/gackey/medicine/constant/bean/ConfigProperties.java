/**
 * title: ConfigProperties.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.constant.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @desc security 配置类
 * @className ConfigProperties
 * @author gackey
 * @date 2020-01-24 15:59
 */
@ConfigurationProperties(prefix = "medicine.security")
public class ConfigProperties {

    BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

}
