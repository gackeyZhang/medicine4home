/**
 * title: MedicineExpiredSessionStrategy.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.config.session;

import java.io.IOException;
import javax.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @desc TODO
 * @className MedicineExpiredSessionStrategy
 * @author gackey
 * @date 2020-04-19 23:20
 */
public class MedicineExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        log.error("user logged in,the IP of user requesting to log in is {} ", event.getRequest().getRemoteHost());
        event.getResponse().setContentType("application/json;charset=UTF-8");
        event.getResponse().getWriter().write("用户在其它地点登录！");
    }

}
