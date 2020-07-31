package com.dakshay.daoimpl;

import com.dakshay.model.SmsTemplate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dakshay on 10/19/2018.
 */
public interface SmsTemplateDao extends CrudRepository<SmsTemplate, Long> {

    List<SmsTemplate> findSmsTemplateByType(String type);
}
