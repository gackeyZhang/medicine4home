/**
 * title: HomeSecurityConfig.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.gackey.medicine.constant.bean.ConfigProperties;

/**
 * @desc Security Config
 * @className HomeSecurityConfig
 * @author gackey
 * @date 2019-12-29 22:03
 */
@Configuration
public class HomeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private AuthenticationSuccessHandler homeAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler homeAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/login")
                .loginProcessingUrl("/authentication/form")
                .successHandler(homeAuthenticationSuccessHandler)
                .failureHandler(homeAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(configProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/login",
                        configProperties.getBrowser().getLoginPage())
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

}
