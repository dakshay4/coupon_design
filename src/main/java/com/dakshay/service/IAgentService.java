package com.dakshay.service;


import com.dakshay.Exception.DException;

import java.util.List;

/**
 * Created by stpl on 20/9/18.
 */
public interface IAgentService<T, S> {
    //Agent Defined functions
    /*List<T> getAllAgents();
    boolean existsById(Long id);
    boolean existsByMobileNo(Long mobileNo);
*//*    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);*//*
    boolean addAgent(T t);
    void updateAgent(T t);
    void deleteAgent(T t);*/

    void addAgent(T t);
    void updateAgent(T t);
    List<T> listAll();
    T getAgentById(S s);
    void deleteAgent(S s);
    void findByMobile(Long mobileNo) throws DException;
    void findByEmail(String email) throws DException;
    void findByMobileNo(Long mobileNo);
}
