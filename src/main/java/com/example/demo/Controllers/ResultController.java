package com.example.demo.Controllers;

import com.example.demo.Mappers.UserInfo;
import com.example.demo.Pojo.Result;
import com.example.demo.Utils.ExceptionEnum;
import com.example.demo.Utils.ExceptionHandle;
import com.example.demo.Utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    @PostMapping("/getResult")
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        Result result = ResultUtil.success();
        try {
            if (name.equals("yg")) {
                result = ResultUtil.success(new UserInfo());
            } else if (name.equals("gy")) {
                result = ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
            } else {
                int i = 1 / 0;
            }
        } catch (Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }
}
