package com.dakshay.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dakshay on 11/10/2018.
 */
@Entity
@Table(name="coupon_code_customer_mapping")
public class CouponCodeCustomerMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "applicable_to_all")
    private Boolean applicableToAll;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="coupon_code")
    private String couponCode;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public CouponCodeCustomerMapping() {
    }

    public CouponCodeCustomerMapping(Boolean applicableToAll, Long customerId, String couponCode) {
        this.applicableToAll = applicableToAll;
        this.customerId = customerId;
        this.couponCode = couponCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getApplicableToAll() {
        return applicableToAll;
    }

    public void setApplicableToAll(Boolean applicableToAll) {
        this.applicableToAll = applicableToAll;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
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
