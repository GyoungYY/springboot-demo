package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam Map<String, Object> reqMap) {
        String name = reqMap.get("name").toString();
        String password = reqMap.get("password").toString();
        return name + password;
    }

    @PostMapping("/createUser2")
    public String createUser2(@Valid UserInfo userInfo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        userService.createUser(userInfo.getTel(),userInfo.getPassword());
        return "OK";
    }
}
