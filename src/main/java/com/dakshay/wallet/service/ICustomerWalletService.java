package com.dakshay.wallet.service;

import com.dakshay.Exception.DException;
import com.dakshay.model.CouponCode;

/**
 * Created by Dakshay on 11/28/2018.
 */
public interface ICustomerWalletService<T,S> {
    CouponCode createWallet(Long customerId) throws DException;
}
