package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.Exception.ErrorCode;
import com.dakshay.Exception.ErrorMessage;
import com.dakshay.daoimpl.CouponCodeCustomerMappingDao;
import com.dakshay.daoimpl.CouponCodeDao;
import com.dakshay.model.CouponCode;
import com.dakshay.model.CouponCodeCustomerMapping;
import com.dakshay.request.CouponCodeRequest;
import com.dakshay.response.PromoCodeResponseBean;
import com.dakshay.wallet.service.CustomerWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CouponCodeService extends BaseService<CouponCode,CouponCodeRequest>
       implements ICouponCodeService<CouponCode> {
    private static Logger log = LoggerFactory.getLogger(CouponCodeService.class);
    private static ThreadLocal<CouponCodeService> couponCodeServiceThreadLocal = new ThreadLocal<>();
    public CouponCodeService getInstance(){
        CouponCodeService couponCodeService = couponCodeServiceThreadLocal.get();
        if(couponCodeService == null) {
            couponCodeServiceThreadLocal.set(new CouponCodeService());
        }
        return couponCodeService;
    }

    @Autowired
    private CouponCodeDao couponCodeDao;

    @Override
    public void addCoupon(CouponCodeRequest couponCodeRequest) throws DException{
        log.info("-----dakshay---");
//    CouponCode transObj = super.getPersistenceObj(couponCodeRequest);
        try {
            List<CouponCode> list = getNonExpiredCouponCodeByType(couponCodeRequest.getCouponType());
            if (list.size() > 0)
                throw new DException(ErrorCode.COUPON_ALREADY_EXISTS, ErrorMessage.COUPON_ALREADY_EXISTS +" and expiring on" + list.get(list.size()-1).getExpiry());
            CouponCode transObj = new CouponCode();
            transObj.setBenefit(couponCodeRequest.getBenefit());
            transObj.setBenefitType(couponCodeRequest.getBenefitType());
            transObj.setBenefitCriteria(couponCodeRequest.getBenefitCriteria());
            transObj.setCount(couponCodeRequest.getCount());
            transObj.setCouponCode(couponCodeRequest.getCouponCode());
            transObj.setCouponType(couponCodeRequest.getCouponType());
            transObj.setExpiry(couponCodeRequest.getExpiry());
            couponCodeDao.save(transObj);
        }catch (DException e){
            throw e;
        }
    }

    @Override
    public List<PromoCodeResponseBean> availableCouponCodes(CouponCodeRequest couponCodeRequest) {

        return null;
    }

    @Autowired
    CustomerWalletService customerWalletService;

    public CouponCode couponBenefit(String type, Long customerId) throws DException{
        List<CouponCode> list = getNonExpiredCouponCodeByType(type);
        if(list.size()==0) {
            throw new DException(ErrorCode.COUPON_NOT_FOUND, ErrorMessage.COUPON_NOT_FOUND);
        }
        for (CouponCode couponCode : list) {
            if (couponCode.getExpiry().after(new Date())) {
                String code = couponCode.getCouponCode();
                if (couponPresentForCustomerOrNot(customerId, code)) {
                    if (canUseCouponCodeOrNot(customerId, couponCode)) {
                        return couponCode;
                    } else {
                        throw new DException(ErrorCode.COUPON_CODE_LIMIT_EXCEEDED, ErrorMessage.COUPON_CODE_LIMIT_EXCEEDED);
                    }
                } else
                    throw new DException(ErrorCode.COUPON_CODE_NOT_APPLICABLE_FOR_USER, ErrorMessage.COUPON_CODE_NOT_APPLICABLE_FOR_USER);
            }
        }

         throw new DException(ErrorCode.COUPON_EXPIRED,ErrorMessage.COUPON_EXPIRED);
    }

    @Autowired
    CouponCodeCustomerMappingDao couponCodeCustomerMappingDao;
    public boolean couponPresentForCustomerOrNot(Long customerId,String code){
        List<CouponCodeCustomerMapping> codeCustomerMapping = couponCodeCustomerMappingDao.findExistingCode(customerId,code);
        if(codeCustomerMapping.size()==0)
            return false;

        return true;
    }

    @Autowired
    CouponCodeTransactionService couponCodeTransactionService;
    public boolean canUseCouponCodeOrNot(Long customerId,CouponCode couponCode){
        Integer txns = couponCodeTransactionService.totalOrdered(customerId,couponCode.getCouponCode());
        if(txns < couponCode.getCount()){
            return true;
        }
        return false;
    }

    public List<CouponCode> getNonExpiredCouponCodeByType(String type){
        return couponCodeDao.findCouponCodeByCouponTypeAndExpiryAfter(type, new Date());
    }
}
