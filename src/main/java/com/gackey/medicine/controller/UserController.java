/**
 * title: UserController.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc query user info
 * @className UserController
 * @author gackey
 * @date 2020-02-04 01:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @desc 获取当前用户
     * @name getCurrentUser
     * @return Object
     * @throws
     */
    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }
}
