/**
 * title: ResponseObj.java
 * copyleft:©2019-2020 gackey. All Rights Reserved.
 */
package com.gackey.medicine.model;

/**
 * @desc simple response object
 * @className ResponseObj
 * @author gackey
 * @date 2020-01-24 15:53
 */
public class ResponseObj {

    private Object obj;

    public ResponseObj(Object obj) {
        super();
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
