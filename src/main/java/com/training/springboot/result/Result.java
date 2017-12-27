package com.training.springboot.result;

/**
 * Created by lenovo on 2017/12/25.
 */
public class Result<T> {

    private boolean success;

    private String code;

    private String msg;

    private Object data;

    public Result(boolean success,String code,String data){
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(){

    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
