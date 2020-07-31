package com.dakshay.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dakshay on 11/25/2018.
 */
@Entity
@Table(name="coupon_code_transaction")
public class CouponCodeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="customer_id")
    Long customerId;
    @Column(name="coupon_code_used")
    String couponCodeUsed;
    @Column(name="status")
    String status;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    public CouponCodeTransaction(Long customerId, String couponCodeUsed, String status) {
        this.customerId = customerId;
        this.couponCodeUsed = couponCodeUsed;
        this.status = status;
    }

    public CouponCodeTransaction(Long customerId, String couponCodeUsed, String status, Date createdAt, Date updatedAt) {
        this.customerId = customerId;
        this.couponCodeUsed = couponCodeUsed;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CouponCodeTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCouponCodeUsed() {
        return couponCodeUsed;
    }

    public void setCouponCodeUsed(String couponCodeUsed) {
        this.couponCodeUsed = couponCodeUsed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
