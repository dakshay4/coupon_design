package com.dakshay.daoimpl;

import com.dakshay.model.CustomerProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dakshay on 11/17/2018.
 */
public interface CustomerProfileDao extends CrudRepository<CustomerProfile,Long>{
    List<CustomerProfile> findCustomerProfileByEmailId(String emailId);
    List<CustomerProfile> findCustomerProfileByCustomerId(Long customerId);
}
