/**
 * title: HomeAuthenticationFailHandler.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gackey.medicine.constant.bean.ConfigProperties;
import com.gackey.medicine.constant.enumerate.LoginType;
import com.gackey.medicine.model.ResponseObj;

import javassist.expr.NewArray;

/**
 * @desc 校验失败后自定义处理器
 * @className HomeAuthenticationFailHandler
 * @author gackey
 * @date 2020-01-29 21:31
 */
@Component("homeAuthenticationFailureHandler")
public class HomeAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        log.error("login FAIL");
        if (LoginType.JSON.equals(configProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new ResponseObj(exception.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

}
