package com.dakshay.service;

import com.dakshay.Exception.DException;

/**
 * Created by Dakshay on 11/17/2018.
 */
public interface ICustomerProfileService<T> {
    void updateProfile(T t) throws DException;
}
