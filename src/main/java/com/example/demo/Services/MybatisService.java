package com.example.demo.Services;

import com.example.demo.Dao.MybatisUserAnnotationMapper;
import com.example.demo.Mappers.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MybatisService {

    @Autowired
    private MybatisUserAnnotationMapper annotationMapper;

    public void createUserByMap(Map<String,Object> reqMap){
        annotationMapper.createUserByMap(reqMap);
    }

    public UserInfo getUser(Integer id){
        return annotationMapper.getUser(id);
    }

    public void updateUser(Integer id,String nickName){
        annotationMapper.updateUser(id,nickName);
    }

    public void deleteUserByUserTel(UserInfo userInfo){
        annotationMapper.deleteUserByUserTel(userInfo);
    }
}
