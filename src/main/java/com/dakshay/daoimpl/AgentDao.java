package com.dakshay.daoimpl;

import com.dakshay.model.Agent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by stpl on 10/9/18.
 */
public interface AgentDao extends AgentDaoCustom, CrudRepository<Agent, Long> {
        List<Agent> findByMobileNo(Long mobileNo);
}