package com.example.demo.Dao;

import com.example.demo.Mappers.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface MybatisUserXMLMapper {
    void createUserByMap(Map<String,Object> reqMap);

    UserInfo getUser(@Param("id") Integer id);

    void updateUser(@Param("id") Integer id,@Param("nickName") String nickName);

    void deleteUserByUserTel(UserInfo userInfo);
}
