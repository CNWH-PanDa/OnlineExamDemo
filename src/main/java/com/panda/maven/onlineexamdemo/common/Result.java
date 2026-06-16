package com.panda.maven.onlineexamdemo.common;

import lombok.Data;


@Data
public class Result {
    private String code;
    private Object data;
    private String msg;

    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";


    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result loginSuccess(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        result.setMsg("登录成功");
        return result;
    }

    public static Result addSuccess(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg("添加成功");
        return result;
    }

    public static Result deleteSuccess(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg("删除成功");
        return result;
    }



}


