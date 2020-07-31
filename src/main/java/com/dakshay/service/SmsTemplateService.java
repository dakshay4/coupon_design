package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.SmsTemplateDao;
import com.dakshay.model.SmsTemplate;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dakshay on 10/19/2018.
 */
@Service
public class SmsTemplateService implements ISmsTemplateService<SmsTemplate> {
    private static Logger log = LoggerFactory.getLogger(SmsTemplateService.class);
    @Autowired
    SmsTemplateDao smsTemplateDao;

    @Override
    public List<SmsTemplate> findAll() {
        List<SmsTemplate> list = new ArrayList<>();
        smsTemplateDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public void save(SmsTemplate smsTemplate) {
        smsTemplateDao.save(smsTemplate);
    }

    @Override
    public String findSmsTemplateByType(String type) throws DException{
        log.info("Fetching template of type =>" +type);
        try {
            List<SmsTemplate> list = smsTemplateDao.findSmsTemplateByType(type);
            if (list.size() == 1) {
                return list.get(0).getMessage();
            } else {
                throw new DException(ErrorCode.EXTRA_DATABASE_VALUES, ErrorMessage.EXTRA_DATABASE_VALUES);
            }
        }catch (HibernateException e){
            throw new DException("Hibernate Exception");
        }
    }
}
