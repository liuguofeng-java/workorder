package com.workorder.utils.result;

import lombok.Data;

/**
 * 接口统一返回
 */
@Data
public class JsonResult {

    private int code;
    private String status;
    private String message;
    private Object data;
    private int PageCount;
    private int PageNumber;
    private JsonResult(){}
    public JsonResult(int code,String status,String message, Object data){
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public JsonResult(int code,String status,String message, Object data,int pageCount,int pageNumber){
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.PageCount = pageCount;
        this.PageNumber = pageNumber;
    }


}