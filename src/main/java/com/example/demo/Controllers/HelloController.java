package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String say(){
        return "Hello yangguang!Your fisrt springboot appliication is success";
    }

    @RequestMapping(value="getList",method = RequestMethod.GET)
    public String getList(){
        return "list list list ....";
    }
}
