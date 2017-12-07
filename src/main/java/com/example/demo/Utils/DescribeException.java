package com.example.demo.Utils;

public class DescribeException extends RuntimeException {

    private Integer code;

    public DescribeException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public DescribeException(String message,Integer code){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code){
        this.code = code;
    }
}
