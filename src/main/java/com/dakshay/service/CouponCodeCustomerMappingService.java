package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.CouponCodeCustomerMappingDao;
import com.dakshay.daoimpl.CouponCodeDao;
import com.dakshay.model.CouponCode;
import com.dakshay.model.CouponCodeCustomerMapping;
import com.dakshay.request.CouponCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Dakshay on 11/19/2018.
 */
@Service
public class CouponCodeCustomerMappingService implements ICouponCodeCustomerMappingService<CouponCodeCustomerMapping> {

    @Autowired
    CouponCodeCustomerMappingDao couponCodeCustomerMappingDao;

    @Autowired
    CouponCodeDao couponCodeDao;

    @Override
    public void addCustomerCoupon(Boolean applicableToAll, Long customerId, String type) throws DException{
        CouponCodeCustomerMapping couponCodeCustomerMapping = new CouponCodeCustomerMapping();
        try {
            couponCodeCustomerMapping.setCustomerId(customerId);

            List<CouponCode> couponCodeList = couponCodeDao.findCouponCodeByCouponTypeAndExpiryAfter(type, new Date());
            String code ;
            if (couponCodeList.size()!=0) {
                CouponCode couponCode = couponCodeList.get(couponCodeList.size()-1);
                code = couponCode.getCouponCode();
                List<CouponCodeCustomerMapping> list = couponCodeCustomerMappingDao.findExistingCode(customerId,code);
                if (list.size() > 0) {
                    throw new DException(ErrorCode.COUPON_ALREADY_EXISTS,ErrorMessage.COUPON_ALREADY_EXISTS);
                }
                couponCodeCustomerMapping.setApplicableToAll(applicableToAll);
                couponCodeCustomerMapping.setCouponCode(code);
                couponCodeCustomerMappingDao.save(couponCodeCustomerMapping);
            }
        }catch (DException e){
            e.printStackTrace();
            if(applicableToAll)
                  throw e;
        }
    }

    public void addCustomerCoupon(CouponCodeRequest couponCodeRequest) throws DException{
        String customerIdCommaSeparated = couponCodeRequest.getCustomerId();
        try {
            Long customerId = null;
            String type = couponCodeRequest.getCouponType();

            if (!customerIdCommaSeparated.equalsIgnoreCase("ALL")) {
                String[] listOfCustomerIds = customerIdCommaSeparated.split(",");
                for (int i = 0; i < listOfCustomerIds.length; i++) {
                    customerId = Long.parseLong(listOfCustomerIds[i].trim());
                    addCustomerCoupon(false, customerId, type);
                }
            } else
                addCustomerCoupon(true, customerId, type);
        }catch(DException e){
            if("ALL".equalsIgnoreCase(customerIdCommaSeparated))
                throw e;
        }
    }
}
