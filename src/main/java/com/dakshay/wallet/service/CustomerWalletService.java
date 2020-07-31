package com.dakshay.wallet.service;

import com.dakshay.Exception.DException;
import com.dakshay.model.CouponCode;
import com.dakshay.service.CouponCodeService;
import com.dakshay.wallet.daoimpl.CustomerWalletDao;
import com.dakshay.wallet.model.CustomerWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dakshay on 11/22/2018.
 */
@Service
public class CustomerWalletService implements ICustomerWalletService<CustomerWallet,Long>{

    private static CustomerWalletService customerWalletService;

    private static ThreadLocal<CustomerWalletService> couponCodeServiceThreadLocal = new ThreadLocal<>();
    public CustomerWalletService getInstance(){
        CustomerWalletService customerWalletService = couponCodeServiceThreadLocal.get();
        if(customerWalletService == null) {
            customerWalletService = new CustomerWalletService();
            couponCodeServiceThreadLocal.set(customerWalletService);
        }
        return customerWalletService;
    }

    @Autowired
    CouponCodeService couponCodeService;

    @Autowired
    CustomerWalletDao customerWalletDao;


    public void updateCashbackBalance(CouponCode couponCode, CustomerWallet customerWallet) {
        if("FIXED".equals(couponCode.getBenefitCriteria())){
            Double existingCashbackBalance =  customerWallet.getCashbackBalance();
            Integer cashBackAmount = couponCode.getBenefit();
            Double newCashBackBalance = existingCashbackBalance + Double.valueOf(cashBackAmount);
            customerWallet.setCashbackBalance(newCashBackBalance);
            customerWalletDao.save(customerWallet);

        }
    }
    @Override
    public CouponCode createWallet(Long customerId) throws DException{
        CustomerWallet customerWallet ;
        CouponCode couponCode = null;
        try{
            customerWallet = customerWalletDao.findCustomerWalletByCustomerId(customerId);
            if(customerWallet == null){
                customerWallet = new CustomerWallet();
                customerWallet.setCustomerId(customerId);
            }
            couponCode = couponCodeService.couponBenefit("REGISTRATION",customerId);
            updateCashbackBalance(couponCode, customerWallet);
            customerWalletDao.save(customerWallet);

        }catch (DException e){
            throw e;
        }
        return couponCode;
    }
}
