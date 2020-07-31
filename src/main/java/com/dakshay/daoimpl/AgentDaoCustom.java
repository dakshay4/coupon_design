package com.dakshay.daoimpl;

import com.dakshay.model.Agent;

import java.util.List;

/**
 * Created by Dakshay on 10/6/2018.
 */
public interface AgentDaoCustom {
    List<Agent> findByMobile(Long mobileNo);
    List<Agent> findByEmail(String email);
}
