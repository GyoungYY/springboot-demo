package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Services.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    //@RequestBody对form-data、form-urlencoded都不行，@RequestParam都可以
    @PostMapping("/createUserByMap")
    public void createUserByMap(@RequestParam Map<String ,Object> reqMap){
        mybatisService.createUserByMap(reqMap);
    }

    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable("id") Integer id){
        return mybatisService.getUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") Integer id,@RequestParam("nickName") String nickName){
        mybatisService.updateUser(id,nickName);
    }

    @DeleteMapping("/deleteUserByUserTel/{tel}")
    public void deleteUserByUserTel(@PathVariable("tel") String tel){
        UserInfo userInfo = new UserInfo();
        userInfo.setTel(tel);
        mybatisService.deleteUserByUserTel(userInfo);
    }

}
