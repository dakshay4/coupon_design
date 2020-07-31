package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.request.CustomerRegistrationRequest;

/**
 * Created by Dakshay on 11/19/2018.
 */
public interface ICouponCodeCustomerMappingService<T> {
    void addCustomerCoupon(Boolean applicableToAll, Long aLong, String s) throws DException;
}
