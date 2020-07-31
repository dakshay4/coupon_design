package com.dakshay.daoimpl;

import com.dakshay.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dakshay on 11/15/2018.
 */
public interface CustomerDao extends CrudRepository<Customer,Long> {
    List<Customer> findCustomerByMobileNo(Long mobileNo);
}
