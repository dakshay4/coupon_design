package com.dakshay.controller;

import com.dakshay.Exception.DException;
import com.dakshay.model.CouponCode;
import com.dakshay.request.CouponCodeRequest;
import com.dakshay.response.CommonResponseBean;
import com.dakshay.response.PromoCodeResponseBean;
import com.dakshay.service.CouponCodeCustomerMappingService;
import com.dakshay.service.CouponCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dakshay on 11/18/2018.
 */
@RestController
public class CouponController {

    @Autowired
    private CouponCodeService couponCodeService;

    @Autowired
    private CouponCodeCustomerMappingService couponCodeCustomerMappingService;

    @PostMapping(path="/addCouponCode")
    @Transactional
    public @ResponseBody
    PromoCodeResponseBean addCoupon(@RequestBody CouponCodeRequest couponCodeRequest){
        PromoCodeResponseBean responseBean;
        try {

            couponCodeService.addCoupon(couponCodeRequest);
            couponCodeCustomerMappingService.addCustomerCoupon(couponCodeRequest);
            responseBean = new PromoCodeResponseBean("Successfully added coupon");
        }catch (DException e){
            responseBean = new PromoCodeResponseBean(e.getErrorCode(),e.getErrorMessage());
        }
        return  responseBean;
    }

    @PostMapping(path="/couponValid")
    public @ResponseBody PromoCodeResponseBean checkCoupon(@RequestBody CouponCodeRequest couponCodeRequest){
        PromoCodeResponseBean responseBean;
        try {
            CouponCode couponCode = couponCodeService.couponBenefit(couponCodeRequest.getCouponCode(), Long.parseLong(couponCodeRequest.getCustomerId()));
            responseBean = new PromoCodeResponseBean(0,"Coupon applied. You will get cashback of " + couponCode.getMaxBenefit());
        }catch (DException e){
            responseBean = new PromoCodeResponseBean(e.getErrorCode(),e.getErrorMessage());
        }
        return responseBean;
    }
    @PostMapping(path="/availableCouponCode")
    public @ResponseBody
    List<PromoCodeResponseBean> availableCouponCode(@RequestBody CouponCodeRequest couponCodeRequest){
        List<PromoCodeResponseBean> responseBean = couponCodeService.availableCouponCodes(couponCodeRequest);
        return  responseBean;
    }
}
