package com.xiecl.myShop.commons.dto;

import com.xiecl.myShop.commons.constans.ConstansUtil;

import java.io.Serializable;

public class BaseResult implements Serializable{
    private int status;
    private String message;
    private Object data;
    public static BaseResult success(){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_SUCCESS,"成功",null);
        return result;
    }
    public static BaseResult success(String message){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_SUCCESS,message,null);
        return result;
    }
    public static BaseResult success(String message,Object data){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_SUCCESS,message,data);
        return result;
    }

    public static BaseResult fail(){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_ERROR,"失败",null);
        return result;
    }
    public static BaseResult fail(String message){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_ERROR,message,null);
        return result;
    }
    public static BaseResult fail(String message,Object data){
        BaseResult result=crateResult(ConstansUtil.RESULT_CODE_ERROR,message,data);
        return result;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static BaseResult crateResult(int status, String message, Object data){
        BaseResult result=new BaseResult();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
