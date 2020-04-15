/**
 * title: MyUserDetailsService.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @desc verify user's authentication
 * @className MyUserDetailsService
 * @author gackey
 * @date 2020-01-06 06:32
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(String.format("user name is === %s", username));
        //TODO: find user by username in mybatis
        return new User(username, "123", true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
