package com.dakshay.controller;

import com.dakshay.CommonUtility.ClassToMap;
import com.dakshay.CommonUtility.IClassToMap;
import com.dakshay.model.CouponCode;
import com.dakshay.request.CouponCodeRequest;
import com.dakshay.response.CommonResponseBean;
import com.dakshay.Exception.DException;
import com.dakshay.model.Agent;
import com.dakshay.response.PromoCodeResponseBean;
import com.dakshay.service.AgentService;
import com.dakshay.service.CouponCodeService;
import com.dakshay.service.SmsProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**1
 * Created by stpl on 10/9/18.
 */
@RestController
public class AppController {
    private static Logger log = LoggerFactory.getLogger(AppController.class);
    @Autowired
    private AgentService agentService;
    @Autowired
    private SmsProviderService smsProviderService;
    public void setAgentService(AgentService agentService) {

        this.agentService = agentService;
    }
    @PostMapping(path="/addAgent")
    @Transactional
    public CommonResponseBean addNewUser(@RequestBody Agent agent) {
        agent.setRegistrationDate(new Date());
        CommonResponseBean response = null;
        log.info("--playerRegistration started--" + agent.toString());
        try {
            this.agentService.findByMobile(agent.getMobileNo());
            this.agentService.findByEmail(agent.getEmail());
            this.agentService.findByMobileNo(agent.getMobileNo());
            agent.setStatus("INACTIVE");
            this.agentService.addAgent(agent);
            /*new Runnable(){
                @Override
                public void run(){
                    try {
                        smsProviderService.generateSms(agent, "REG_SMS");
                    }catch (Exception e){
                        throw new e;
                    }
                }

            };*/
            Runnable messageTask = () -> {
                try {
                    IClassToMap classToMap = new ClassToMap<Agent>();
                    smsProviderService.prepareMessageContentAndSend(agent.getMobileNo(),classToMap.getClassToMap(agent), "AGENT_REG_SMS");

                }catch (Exception e){
                    e.printStackTrace();
                }
            };
            new Thread(messageTask).start();
            response = new CommonResponseBean(0, "saved successfully");
        } catch (DException de) {
            response = new CommonResponseBean(de.getErrorCode(), de.getErrorMessage());
            de.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return response;
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Agent> getAllUsers(){
        return agentService.listAll();
    }
    @GetMapping(path="/hi", consumes = "application/json")
    public @ResponseBody
    String sayHello(@RequestBody String name){
        return "Hello " + name;
    }


}
