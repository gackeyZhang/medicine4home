/**
 * title: BrowserSecurityController.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gackey.medicine.constant.bean.ConfigProperties;
import com.gackey.medicine.model.ResponseObj;

/**
 * @desc TODO
 * @className BrowserSecurityController
 * @author gackey
 * @date 2020-01-18 23:27
 */
@RestController
public class BrowserSecurityController {

    private Logger log = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectstrategy = new DefaultRedirectStrategy();

    private ConfigProperties configProperties;

    /**
     * @throws IOException 
     * @desc 当需要身份认证时，跳转到该方法 
     * @name requireAuthentication
     * @param req
     * @param resp
     * @return ResponseObj
     */
    @RequestMapping("/authentication/login")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseObj requireAuthentication(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SavedRequest saveRequest = requestCache.getRequest(req, resp);
        if (Optional.of(saveRequest).isPresent()) {
            // 引发跳转的请求
            String redirectUrl = saveRequest.getRedirectUrl();
            log.info("The request that raises the jump is {}", redirectUrl);
            if (StringUtils.endsWithIgnoreCase(redirectUrl, ".html")) {
                redirectstrategy.sendRedirect(req, resp, configProperties.getBrowser().getLoginPage());
            }
        }
        return new ResponseObj("用户认证失败，需要重新登录");
    }

    @GetMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseObj sessionInvalid() {
        return new ResponseObj("session失效");
    }
}
