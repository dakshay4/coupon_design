package com.dakshay.daoimpl;

import com.dakshay.model.Agent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Dakshay on 10/6/2018.
 */
@Repository
@Transactional(readOnly = true)
public class AgentDaoCustomImpl implements AgentDaoCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Agent> findByMobile(Long mobileNo){
        /*Query query = entityManager.createNativeQuery("SELECT ag.* FROM travel_agent as ag" +
                "where ag.mobile_no = ?",Agent.class);
        query.setParameter(1,mobileNo);
        Agent ag = (Agent) query.getResultList().get(0);*/
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Agent> criteriaQuery = cb.createQuery(Agent.class);
        Root<Agent> agentRoot = criteriaQuery.from(Agent.class);
        criteriaQuery.select(agentRoot);
        criteriaQuery.where(cb.equal(agentRoot.get("mobileNo"),mobileNo));
        List<Agent> list = entityManager.createQuery(criteriaQuery).getResultList();

        return list;

    }

    @Override
    public List<Agent> findByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Agent> criteriaQuery = cb.createQuery(Agent.class);
        Root<Agent> agentRoot = criteriaQuery.from(Agent.class);
        criteriaQuery.select(agentRoot);
        criteriaQuery.where(cb.equal(agentRoot.get("email"),email));
        List<Agent> list = entityManager.createQuery(criteriaQuery).getResultList();

        return list;
    }
}
