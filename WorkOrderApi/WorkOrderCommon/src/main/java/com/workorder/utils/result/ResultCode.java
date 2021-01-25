package com.workorder.utils.result;

import com.workorder.utils.result.JsonResult;

/**
 * 接口统一返回
 */
public class ResultCode {
    public final static String SUCCESS_STATUS="success";
    public final static String ERROR_STATUS="error";

    public final static int ERROR_CODE=500;//服务器异常
    public final static int SUCCESS_CODE=200;//请求成功
    public final static int NOT_LOGIN_CODE=400;//未登录

    public static JsonResult success(String message, Object data){
        return new JsonResult(SUCCESS_CODE,SUCCESS_STATUS,message,data);
    }
    public static JsonResult success(String message){
        return new JsonResult(SUCCESS_CODE,SUCCESS_STATUS,message,null);
    }

    public static JsonResult error(int code,String message){
        return new JsonResult(code,ERROR_STATUS,message,null);
    }

    public static JsonResult error(String message){
        return new JsonResult(SUCCESS_CODE,ERROR_STATUS,message,null);
    }

    public static JsonResult all(int code,String status,String message,Object data,int pageCount,int pageNumber){
        return new JsonResult(code,status,message,data,pageCount,pageNumber);
    }

    public static JsonResult all(int code,String status,String message,int pageCount,int pageNumber){
        return new JsonResult(code,status,message,null,pageCount,pageNumber);
    }

    public static JsonResult all(int code,String status,String message){
        return new JsonResult(code,status,message,null,0,0);
    }

    public static JsonResult all(int code,String status,String message,Object data){
        return new JsonResult(code,status,message,data,0,0);
    }
}