package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Pojo.Result;
import com.example.demo.Services.MybatisXMLService;
import com.example.demo.Utils.ExceptionHandle;
import com.example.demo.Utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mybatis2")
public class MybatisXMLController {

    @Autowired
    private MybatisXMLService mybatisService;

    @Autowired
    private ExceptionHandle exceptionHandle;

    //@RequestBody对form-data、form-urlencoded都不行，@RequestParam都可以
    @PostMapping("/createUserByMap")
    public Result createUserByMap(@RequestParam Map<String, Object> reqMap) {
//        mybatisService.createUserByMap(reqMap);

        //下面使用统一结果处理
        Result result = ResultUtil.success();
        try {
            mybatisService.createUserByMap(reqMap);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Integer id) {
//        return mybatisService.getUser(id);
        Result result = ResultUtil.success();
        try {
            result.setData(mybatisService.getUser(id));
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    @PutMapping("/updateUser/{id}")
    public Result updateUser(@PathVariable("id") Integer id, @RequestParam("nickName") String nickName) {
//        mybatisService.updateUser(id, nickName);
        Result result = ResultUtil.success();
        try {
            mybatisService.updateUser(id, nickName);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    @DeleteMapping("/deleteUserByUserTel/{tel}")
    public Result deleteUserByUserTel(@PathVariable("tel") String tel) {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setTel(tel);
//        mybatisService.deleteUserByUserTel(userInfo);
        Result result = ResultUtil.success();
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setTel(tel);
            mybatisService.deleteUserByUserTel(userInfo);
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

}

