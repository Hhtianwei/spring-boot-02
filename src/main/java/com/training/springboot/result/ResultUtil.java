package com.training.springboot.result;

/**
 * Created by lenovo on 2017/12/25.
 */
public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setCode("00");
        result.setSuccess(true);
        result.setMsg("success");
        return result;
    }

    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
