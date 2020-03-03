/**
 * title: ValidateCodeException.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.constant.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @desc TODO
 * @className ValidateCodeException
 * @author gackey
 * @date 2020-03-01 22:51
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 3262103620681774760L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
