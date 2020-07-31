package com.dakshay.controller;

import com.dakshay.response.CommonResponseBean;
import com.dakshay.model.SmsProvider;
import com.dakshay.model.SmsTemplate;
import com.dakshay.service.SmsProviderService;
import com.dakshay.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dakshay on 10/18/2018.
 */
@RestController
public class BOController {

    @Autowired
    SmsProviderService smsProviderService;

    @Autowired
    SmsTemplateService smsTemplateService;

    @PostMapping(path="/addSmsProvider")
    CommonResponseBean addSmsProvider(@RequestBody SmsProvider smsProvider){
        CommonResponseBean response = null;
        try {
            smsProviderService.save(smsProvider);
            response = new CommonResponseBean(0, "saved successfully");
        }
        catch (RuntimeException de){
            response.setMessage("HibernaeEx");
            response.setCode(1);
        }
        return response;
    }
    @PostMapping(path="/addSmsTemplate")
    CommonResponseBean addSmsTemplate(@RequestBody SmsTemplate smsTemplate){
        CommonResponseBean response = null;
        try {
            smsTemplateService.save(smsTemplate);
            response = new CommonResponseBean(0, "saved successfully");
        }
        catch (RuntimeException de){
            response.setMessage("HibernaeEx");
            response.setCode(1);
        }
        return response;
    }
}
