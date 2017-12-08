package com.example.demo.Dao;

import com.example.demo.Pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

//    List<Address> findByUserId(Long userId);
//
//    Address findByAddressIdAndUserId(Long addressId,Long userId);
//
//    @Query(value="select t from Address t where t.addressInfo = :addressInfo")
//    Address findAddress(@Param("addressInfo") String addressInfo);
}
