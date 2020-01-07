/**
 * title: HomeSecurityConfig.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @desc Security Config
 * @className HomeSecurityConfig
 * @author gackey
 * @date 2019-12-29 22:03
 */
@Configuration
public class HomeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and().authorizeRequests().anyRequest()
                .authenticated();
    }

}
