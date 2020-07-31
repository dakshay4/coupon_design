package com.dakshay.wallet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dakshay on 11/22/2018.
 */
@Entity
@Table(name="customer_wallet")
public class CustomerWallet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wallet_id")
    private Long walletId;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="wallet_balance")
    private double walletBalance;
    @Column(name="cashback_balance")
    private double cashbackBalance;

    public CustomerWallet() {
    }

    public CustomerWallet(Long customerId, double walletBalance, double cashbackBalance) {
        this.customerId = customerId;
        this.walletBalance = walletBalance;
        this.cashbackBalance = cashbackBalance;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public double getCashbackBalance() {
        return cashbackBalance;
    }

    public void setCashbackBalance(double cashbackBalance) {
        this.cashbackBalance = cashbackBalance;
    }
}
