package com.example.demo.Services;

import com.example.demo.Dao.MybatisUserXMLMapper;
import com.example.demo.Mappers.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MybatisXMLService {

    @Autowired
    private MybatisUserXMLMapper xmlMapper;

    public void createUserByMap(Map<String, Object> reqMap) {
        xmlMapper.createUserByMap(reqMap);
    }

    public UserInfo getUser(Integer id) {
        return xmlMapper.getUser(id);
    }

    public void updateUser(Integer id, String nickName) {
        xmlMapper.updateUser(id, nickName);
    }

    public void deleteUserByUserTel(UserInfo userInfo) {
        xmlMapper.deleteUserByUserTel(userInfo);
    }
}

