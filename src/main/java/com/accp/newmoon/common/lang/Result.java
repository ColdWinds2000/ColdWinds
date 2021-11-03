package com.accp.newmoon.common.lang;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result implements Serializable {
    //200是正常,非200表示异常
    private int code;
    private String msg;
    private Object data;

    //成功的结果返回
    public static Result success(Object data){
        return success(200,"操作成功",data);
    }
    //成功的结果返回
    public static Result success(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    //数据异常结果返回
    public static Result fail(String msg){
        return fail(400,msg,null);
    }
    //数据异常结果返回
    public static Result fail(String msg,Object data){
        return fail(400,msg,data);
    }
    //数据异常结果返回
    public static Result fail(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
