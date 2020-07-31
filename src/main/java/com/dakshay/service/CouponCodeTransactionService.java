package com.dakshay.service;

import com.dakshay.daoimpl.CouponCodeTransactionDao;
import com.dakshay.model.CouponCodeTransaction;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

/**
 * Created by Dakshay on 11/25/2018.
 */
@Service
public class CouponCodeTransactionService {
    private static ThreadLocal<CouponCodeTransactionService> couponCodeServiceThreadLocal = new ThreadLocal<>();

    public CouponCodeTransactionService getInstance() {
        CouponCodeTransactionService couponCodeTransactionService = couponCodeServiceThreadLocal.get();
        if (couponCodeTransactionService == null) {
            couponCodeServiceThreadLocal.set(new CouponCodeTransactionService());
        }
        return couponCodeTransactionService;
    }

    @Autowired
    CouponCodeTransactionDao couponCodeTransactionDao;

    public Integer totalOrdered(Long customerId, String code) {

        List<CouponCodeTransaction> l = couponCodeTransactionDao.findAllByCustomerIdAndAndCouponCodeUsed(customerId, code);
        return l.size();
    }

    public void updateTransaction(Long customerId, String couponCode, String status){
        CouponCodeTransaction couponCodeTransaction = null;
        try{
            couponCodeTransaction = new CouponCodeTransaction(customerId,couponCode,status);
            couponCodeTransaction.setUpdatedAt(new Date());
            couponCodeTransactionDao.save(couponCodeTransaction);
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }
}
