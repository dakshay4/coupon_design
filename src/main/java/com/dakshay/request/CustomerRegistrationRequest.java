package com.dakshay.request;

import java.io.Serializable;

/**
 * Created by Dakshay on 10/28/2018.
 */
public class CustomerRegistrationRequest implements Serializable{
    private Integer code;
    private Long mobileNo;
    private String password;
    private String referredFrom;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReferredFrom() {
        return referredFrom;
    }

    public void setReferredFrom(String referredFrom) {
        this.referredFrom = referredFrom;
    }
}
