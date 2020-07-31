package com.dakshay.daoimpl;

import com.dakshay.model.SmsProvider;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dakshay on 10/16/2018.
 */
public interface SmsDao extends CrudRepository<SmsProvider, Long> {

    public SmsProvider findSmsProviderByStatus(String status);
    public SmsProvider findSmsProviderByProviderName(String providerName);
}
