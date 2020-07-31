package com.dakshay.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dakshay on 10/31/2018.
 */
@Entity
@Table(name="coupon_code")
public class CouponCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "coupon_type")
    private String couponType;
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "count")
    private Integer count;
    @Column(name = "benefit_type")
    private String benefitType;
    @Column(name = "benefit_criteria")
    private String benefitCriteria;
    @Column(name="max_benefit")
    private Integer maxBenefit;
    @Column(name = "benefit")
    private Integer benefit;
    @Column(name = "expiry")
    private Date expiry;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public CouponCode() {
    }

    public CouponCode(String couponType, String couponCode, Integer count, String benefitType, String benefitCriteria, Integer maxBenefit, Integer benefit, Date expiry) {
        this.couponType = couponType;
        this.couponCode = couponCode;
        this.count = count;
        this.benefitType = benefitType;
        this.benefitCriteria = benefitCriteria;
        this.maxBenefit = maxBenefit;
        this.benefit = benefit;
        this.expiry = expiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
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

    public Integer getMaxBenefit() {
        return maxBenefit;
    }

    public void setMaxBenefit(Integer maxBenefit) {
        this.maxBenefit = maxBenefit;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
