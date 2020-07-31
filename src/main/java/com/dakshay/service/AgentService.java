package com.dakshay.service;


import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.AgentDao;
import com.dakshay.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stpl on 20/9/18.
 */
@Service

public class AgentService implements IAgentService<Agent,Long> {
    @Autowired
    private AgentDao agentDao;


    @Override
    public void addAgent(Agent agent) {
        agentDao.save(agent);
    }

    @Override
    public void updateAgent(Agent agent) {
        agentDao.save(agent);
    }

    @Override
    public List<Agent> listAll() {

        List<Agent> list = new ArrayList<>();
        agentDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentDao.findById(id).get();
    }

    @Override
    public void deleteAgent(Long id) {
        agentDao.delete(getAgentById(id));
    }

    @Override
    public void findByMobile(Long mobileNo) throws DException {
        if(agentDao.findByMobile(mobileNo).size() >0 )
            throw new DException(ErrorCode.AGENT_EXIST, ErrorMessage.AGENT_EXIST);

    }

    @Override
    public void findByEmail(String email) throws DException {
        if(agentDao.findByEmail(email).size() >0 )
            throw new DException(ErrorCode.EMAIL_EXIST, ErrorMessage.EMAIL_EXIST);
    }

    @Override
    public void findByMobileNo(Long mobileNo) {
        List<Agent> list = agentDao.findByMobileNo(mobileNo);
        if(list.size()>=1){
            try {
                throw new DException(ErrorCode.AGENT_EXIST, ErrorMessage.AGENT_EXIST);
            } catch (DException e) {
                e.printStackTrace();
            }
        }
    }


}
