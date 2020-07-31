package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.daoimpl.SmsDao;
import com.dakshay.model.Agent;
import com.dakshay.model.SmsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Dakshay on 10/16/2018.
 */
@Service
public class SmsProviderService implements ISmsProviderService<SmsProvider> {
    @Autowired
    SmsDao smsDao;

    @Autowired
    SmsTemplateService smsTemplateService;


    @Override
    public void prepareMessageContentAndSend(Long mobileNo, Map<String, String> varMap, String type) throws Exception{
        try {
            String message = generateSms(varMap, type);
            sendSms(message, mobileNo);
        }
        catch (DException de){
            throw de;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<SmsProvider> findAll() {
        List<SmsProvider> list = new ArrayList<>();
        smsDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public String generateSms(Map<String,String> varMap, String type) throws DException {
        try {
            /*Map<String,String> varMap = new HashMap<String,String>();
            Iterator it =varMap.entrySet().iterator();
            varMap.put("UserName",agent.getAgentUserName());
            varMap.put("MobileNo",String.valueOf(agent.getMobileNo()));*/

            String message = smsTemplateService.findSmsTemplateByType(type);

            for(String key : varMap.keySet()){
                System.out.println("--key--" + key + "--value---" +varMap.get(key));
                if(message.contains(key)){
                    message = message.replace(key,varMap.get(key));
                }
            }
            message = message.replace("{", "");
            message = message.replace("}", "");
            System.out.println("--Message--" +message);
            return message;
        }
        catch (DException e){
            throw e;
        }

    }

    @Override
    public void save(SmsProvider smsProvider) throws RuntimeException{
        try {
           // smsProvider.setPassword(PasswordEnc.generateHash(smsProvider.getPassword()));
            smsDao.save(smsProvider);
        }catch (RuntimeException re) {
            throw new RuntimeException();
        }
    }

    @Override
    public void sendSms(String message, Long mobileNo) throws Exception {
        try {
            SmsProvider smsProvider = smsDao.findSmsProviderByStatus("ACTIVE");
            if ("msg91".equals(smsProvider.getProviderName())) {

                String url = smsProvider.getUrl() + "?country="
                        + URLEncoder.encode("91", "UTF-8") + "&sender="
                        + URLEncoder.encode(smsProvider.getSenderId(), "UTF-8") + "&route="
                        + URLEncoder.encode(smsProvider.getRoute(), "UTF-8") + "&mobiles="
                        + URLEncoder.encode(String.valueOf(mobileNo), "UTF-8") + "&authkey="
                        + URLEncoder.encode(smsProvider.getAuthKey(), "UTF-8") + "&message="
                        + URLEncoder.encode(message, "UTF-8");

                System.out.println("url---" + url);
                URLConnection connection = new URL(url).openConnection();
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                InputStream response = connection.getInputStream();

                System.out.println("---response--" + response);
            }
            else if("smslane".equals(smsProvider.getProviderName())){

                String url = smsProvider.getUrl() + "?apikey="
                        + URLEncoder.encode(smsProvider.getAuthKey(), "UTF-8") + "&msisdn="
                        + URLEncoder.encode(String.valueOf(mobileNo), "UTF-8") + "&sid="
                        + URLEncoder.encode(smsProvider.getSenderId(), "UTF-8") + "&msg="
                        + URLEncoder.encode(message, "UTF-8") + "&fl=0";

                System.out.println("url---" + url);
                URLConnection connection = new URL(url).openConnection();
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                InputStream response = connection.getInputStream();

                System.out.println("---response--" + response);
            }
        }catch(Exception e){
            throw e;
        }
    }


}
