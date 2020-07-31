package com.dakshay.service;

import com.dakshay.CommonUtility.PasswordEnc;
import com.dakshay.CommonUtility.RandomNumber;
import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.CustomerDao;
import com.dakshay.model.Customer;
import com.dakshay.request.CustomerRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dakshay on 11/15/2018.
 */
@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    CustomerDao customerDao;
    @Override
    @Transactional
    public Customer addCustomer(CustomerRegistrationRequest customerRegistrationRequest) throws DException{
        Customer customerBean = null;
        try {
            Customer customer = new Customer();
            customer.setCode(customerRegistrationRequest.getCode());
            customer.setMobileNo(customerRegistrationRequest.getMobileNo());
            if(customerDao.findCustomerByMobileNo(customerRegistrationRequest.getMobileNo()).size()>0 )
                throw new DException(ErrorCode.CUSTOMER_EXIST, ErrorMessage.CUSTOMER_EXIST);
            customer.setPassword(PasswordEnc.generateHash(customerRegistrationRequest.getPassword()));
            customer.setReferredFrom(customerRegistrationRequest.getReferredFrom());
            customer.setReferCode(RandomNumber.getAlphaNumericWord());
            customerBean = customerDao.save(customer);
        }
        catch(Exception e){
            throw e;
        }
        return customerBean;
    }
}
