package com.dakshay.daoimpl;

import com.dakshay.model.CouponCode;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Dakshay on 11/1/2018.
 */
public interface CouponCodeDao extends CrudRepository<CouponCode,Long> {
    List<CouponCode> findCouponCodeByCouponTypeAndExpiryAfter(String type, Date date);
}
