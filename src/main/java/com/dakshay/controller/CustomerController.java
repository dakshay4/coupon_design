package com.dakshay.controller;

import com.dakshay.CommonUtility.ClassToMap;
import com.dakshay.CommonUtility.IClassToMap;
import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.model.CouponCode;
import com.dakshay.model.Customer;
import com.dakshay.request.CustomerProfileRequest;
import com.dakshay.request.CustomerRegistrationRequest;
import com.dakshay.response.CommonResponseBean;
import com.dakshay.service.*;
import com.dakshay.wallet.service.CustomerWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Dakshay on 10/25/2018.
 */
@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;
    @Autowired
    CouponCodeCustomerMappingService couponCodeCustomerMappingService;
    @Autowired
    private SmsProviderService smsProviderService;

    @Autowired
    private CustomerWalletService customerWalletService;

    @Autowired
    private CouponCodeTransactionService couponCodeTransactionService;
    @Transactional
    @PostMapping("/customerRegistration")
    public @ResponseBody synchronized CommonResponseBean addCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        try{
            Customer customer = customerService.addCustomer(customerRegistrationRequest);
            couponCodeCustomerMappingService.addCustomerCoupon(false, customer.getCustomerId(),"REGISTRATION");
//            couponCodeCustomerMappingService.addCustomerCoupon(customer.getCustomerId(),"FIRST_TXN");
            //Wallet Create
            CouponCode couponCode = customerWalletService.createWallet(customer.getCustomerId());
            couponCodeTransactionService.updateTransaction(customer.getCustomerId(),
                    couponCode.getCouponCode(),"DONE");
            Runnable messageTask = () -> {
                try {
                    IClassToMap classToMap = new ClassToMap<Customer>();
                    smsProviderService.prepareMessageContentAndSend(customer.getMobileNo(),classToMap.getClassToMap(customer), "CUSTOMER_REG_SMS");

                }catch (Exception e){
                    e.printStackTrace();
                }
            };
            new Thread(messageTask).start();
            commonResponseBean.setMessage(ErrorMessage.SUCCESS);
        }catch(DException e){
            commonResponseBean = new CommonResponseBean(e.getErrorCode(),e.getErrorMessage());
        }
        return commonResponseBean;
    }
    @Autowired
    CustomerProfileService customerProfileService;
    @PostMapping("/updateProfile")
    public @ResponseBody CommonResponseBean updateProfile(@RequestBody CustomerProfileRequest customerProfileRequest){
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        try{
            customerProfileService.updateProfile(customerProfileRequest);
            commonResponseBean.setMessage(ErrorMessage.SUCCESS);
        }catch(DException e){
            commonResponseBean = new CommonResponseBean(e.getErrorCode(),e.getErrorMessage());
        }
        return commonResponseBean;
    }
}
