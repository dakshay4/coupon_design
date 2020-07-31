package com.dakshay.service;

import com.dakshay.Exception.DException;
import com.dakshay.request.CouponCodeRequest;
import com.dakshay.response.PromoCodeResponseBean;

import java.util.List;

/**
 * Created by Dakshay on 10/31/2018.
 */
public interface ICouponCodeService<T> {
    void addCoupon(CouponCodeRequest couponCodeRequest) throws DException;
    List<PromoCodeResponseBean> availableCouponCodes(CouponCodeRequest couponCodeRequest);

}
