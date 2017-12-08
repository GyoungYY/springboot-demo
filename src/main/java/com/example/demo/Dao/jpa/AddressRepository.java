package com.example.demo.Dao.jpa;

import com.example.demo.Pojo.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//因为配置了mybatis，spring自动扫描dao接口文件，默认当作mybatis的文件了，所以放在jpa包下
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByUserId(Long userId);

    Page<Address> findAll(Pageable pageable);

    Address findByAddressIdAndUserId(Long addressId, Long userId);

    @Query(value = "select  t from Address t where t.addressInfo = :addressInfo")
    Address findAddress(@Param("addressInfo") String addressInfo);
}
