package com.dakshay.service;

import com.dakshay.request.CustomerRegistrationRequest;

/**
 * Created by Dakshay on 11/15/2018.
 */
public interface ICustomerService<T> {
    public T addCustomer(CustomerRegistrationRequest customerRegistrationRequest) throws Exception;
}
