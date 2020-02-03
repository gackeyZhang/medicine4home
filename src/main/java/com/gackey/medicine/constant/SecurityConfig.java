/**
 * title: SecurityConfig.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.constant;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.gackey.medicine.constant.bean.ConfigProperties;

/**
 * @desc TODO
 * @className SecurityConfig
 * @author gackey
 * @date 2020-01-24 16:12
 */
@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
public class SecurityConfig {

}
