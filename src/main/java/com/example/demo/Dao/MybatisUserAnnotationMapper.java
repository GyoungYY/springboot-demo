package com.example.demo.Dao;

import com.example.demo.Mappers.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface MybatisUserAnnotationMapper {

    @Insert("INSERT INTO jinju.jj_user(tel,password,nickname,secret) VALUES(#{tel},md5(#{pwd}),#{tel},'')")
    void createUserByMap(Map<String,Object> reqMap);

    @Select("SELECT tel,nickname,password FROM jinju.jj_user WHERE user_id = #{id}")
    UserInfo getUser(@Param("id") Integer id);

    @Update("UPDATE jinju.jj_user SET nickname = #{nickName} WHERE user_id = #{id}")
    void updateUser(@Param("id") Integer id,@Param("nickName") String nickName);

    @Delete("DELETE FROM jinju.jj_user WHERE tel = #{tel}")
    void deleteUserByUserTel(UserInfo userInfo);
}
