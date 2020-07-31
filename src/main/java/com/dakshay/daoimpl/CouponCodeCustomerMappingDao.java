package com.dakshay.daoimpl;

import com.dakshay.model.CouponCodeCustomerMapping;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Dakshay on 11/10/2018.
 */
public interface CouponCodeCustomerMappingDao extends CrudRepository<CouponCodeCustomerMapping,Long>{

    List<CouponCodeCustomerMapping> findCouponCodeCustomerMappingByCustomerId(Long customerId);

    /*@Query("select CouponCodeCustomerMapping cm where customerId=:customerId AND couponCode")
    Boolean checkCouponApplicableForCustomer(@Param("customerId"),@Param("couponCodes"));*/

    @Query("SELECT u from CouponCodeCustomerMapping u where (u.customerId=:customerId or u.applicableToAll=true) and u.couponCode=:code")
    List<CouponCodeCustomerMapping> findExistingCode(@Param("customerId") Long customerId, @Param("code") String code);
}
