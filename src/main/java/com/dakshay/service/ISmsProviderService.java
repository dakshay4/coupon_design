package com.dakshay.service;

import com.dakshay.model.Agent;

import java.util.List;
import java.util.Map;

/**
 * Created by Dakshay on 10/16/2018.
 */
public interface ISmsProviderService<T> {
    void prepareMessageContentAndSend(Long mobileNo,Map<String,String> varMap,String type) throws Exception;
    List<T> findAll();
    String generateSms(Map<String,String> varMap, String type) throws Exception;
    void save(T t);
    void sendSms(String message, Long mobileNo) throws Exception;
}
