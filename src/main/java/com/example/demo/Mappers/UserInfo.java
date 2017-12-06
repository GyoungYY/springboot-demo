package com.example.demo.Mappers;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tel;
    private String nickName;
    @Max(value = 999999,message = "超过最大数值")
    @Min(value = 000000,message = "密码设定不正确")
    private String passWord;

    public UserInfo(){
    }

    public UserInfo(String tel,String nickName,String passWord){
        this.tel = tel;
        this.nickName = nickName;
        this.passWord = passWord;
    }

    @Override
    public String toString(){
        return "UserInfo{" +
                "tel='" + this.tel + '\'' +
                ",nickName='" + this.nickName + '\'' +
                ",passWord='" + this.passWord + '\'' +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String passWord) {
        this.passWord = passWord;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

}
