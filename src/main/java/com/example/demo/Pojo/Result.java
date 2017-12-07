package com.example.demo.Pojo;

public class Result<T> {
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString(){
        return "Result{" +
                "status=" + this.status +
                ",msg='" + this.msg + '\'' +
                ",data=" + this.data +
                '}';
    }

    private Integer status;
    private String msg;
    private T data;

}
