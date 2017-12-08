package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建用户", notes = "使用手机以及密码初始化用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel", value = "用户手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户初始化密码", required = true, dataType = "String")
    })
    @PostMapping("/createUser")
    public void createUser(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        userService.createUser(tel, pwd);
    }

    @ApiOperation(value = "创建用户2版本", notes = "使用UserInfo对象初始化用户信息")
    @ApiImplicitParam(name = "userInfo", value = "用户对象", required = true, dataType = "UserInfo")
    @PostMapping("/createUser2")
    public String createUser2(@Valid UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        userService.createUser(userInfo.getTel(), userInfo.getPassword());
        return "OK";
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName) {
        userService.updateUser(user_id, nickName);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id,必须添加paramType", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUserByUserId/{id}")
    public void deleteUserByUserId(@PathVariable("id") Integer id) {
        userService.deleteUserByUserId(id);
    }

}
