package com.dakshay.request;

import java.util.Date;

/**
 * Created by Dakshay on 10/21/2018.
 */
public class CouponCodeRequest {
    private String couponCode;
    private String couponType;
    private Integer count;
    private String benefitType;
    private String benefitCriteria;
    private Integer benefit;
    private Date expiry;
    private String customerId;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitCriteria() {
        return benefitCriteria;
    }

    public void setBenefitCriteria(String benefitCriteria) {
        this.benefitCriteria = benefitCriteria;
    }

    public Integer getBenefit() {
        return benefit;
    }

    public void setBenefit(Integer benefit) {
        this.benefit = benefit;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
