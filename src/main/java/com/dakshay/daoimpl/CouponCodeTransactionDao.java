package com.dakshay.daoimpl;

import com.dakshay.model.CouponCodeTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Dakshay on 11/25/2018.
 */
public interface CouponCodeTransactionDao extends CrudRepository<CouponCodeTransaction,Long>{
   /* @Query("SELECT COUNT () from CouponCodeTransaction cT WHERE ct.customerId=:customerId AND ct.couponCodeUsed=:couponCodeUsed")
    List<CouponCodeTransaction> totalOrderedByCouponCode(@Param("customerId") Long customerId,
                                                         @Param("couponCode") String couponCode);*/
   List<CouponCodeTransaction> findAllByCustomerIdAndAndCouponCodeUsed(Long customerId, String couponCodeUsed);
}
