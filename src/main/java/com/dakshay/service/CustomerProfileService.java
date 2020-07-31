package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.CustomerProfileDao;
import com.dakshay.model.CustomerProfile;
import com.dakshay.request.CustomerProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dakshay on 11/17/2018.
 */
@Service
public class CustomerProfileService implements ICustomerProfileService<CustomerProfileRequest>
        {
    @Autowired
    CustomerProfileDao customerProfileDao;
    @Override
    public void updateProfile(CustomerProfileRequest customerProfileRequest) throws DException{
        CustomerProfile customerProfile ;
        try{
            if(customerProfileDao.findCustomerProfileByEmailId(customerProfileRequest.getEmailId()).size()>0){
                throw new DException(ErrorCode.EMAIL_EXIST, ErrorMessage.EMAIL_EXIST);
            }
//            CustomerProfile customerProfile = super.getPersistenceObject(customerProfileRequest);
            customerProfile = new CustomerProfile();
            Long customerId = customerProfileRequest.getCustomerId();
            List<CustomerProfile> list = customerProfileDao.findCustomerProfileByCustomerId(customerId);
            if(list.size()==1){
                CustomerProfile cst = list.get(0);
                customerProfile.setId(cst.getId());
            }
            customerProfile = new CustomerProfile(customerProfileRequest.getCustomerId(),customerProfileRequest.getSalutation(),
                    customerProfileRequest.getFirstName(),customerProfileRequest.getMiddleName(),
                    customerProfileRequest.getLastName(),customerProfileRequest.getEmailId(),
                    customerProfileRequest.getDateOfBirth(),customerProfileRequest.getAddress(),
                    customerProfileRequest.getCity(),customerProfileRequest.getPinCode(),
                    customerProfileRequest.getState(),customerProfileRequest.getCountry(),new Date());
            customerProfileDao.save(customerProfile);
        }catch (DException e){
            throw e;
        }
    }
}
