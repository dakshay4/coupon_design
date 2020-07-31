package com.dakshay.wallet.daoimpl;

import com.dakshay.wallet.model.CustomerWallet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dakshay on 11/22/2018.
 */
public interface CustomerWalletDao extends CrudRepository<CustomerWallet,Long> {
    CustomerWallet findCustomerWalletByCustomerId(Long customerId);
}
