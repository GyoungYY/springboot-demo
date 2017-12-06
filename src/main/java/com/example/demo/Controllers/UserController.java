package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public void createUser(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        userService.createUser(tel, pwd);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName) {
        userService.updateUser(user_id, nickName);
    }

    @GetMapping("/getUser/{id}")
    public UserInfo getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUserByUserId/{id}")
    public void deleteUserByUserId(@PathVariable("id") Integer id) {
        userService.deleteUserByUserId(id);
    }

}
