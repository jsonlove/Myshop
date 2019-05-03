package com.xiecl.myShop.commons.dto;

import java.io.Serializable;

public class BaseResult implements Serializable{
    private int status;
    private String message;

    public static BaseResult success(){
        BaseResult result=crateResult(200,"成功");
        return result;
    }
    public static BaseResult success(String message){
        BaseResult result=crateResult(200,message);
        return result;
    }
    public static BaseResult fail(){
        BaseResult result=crateResult(500,"失败");
        return result;
    }
    public static BaseResult fail(String message){
        BaseResult result=crateResult(500,message);
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

    private static BaseResult crateResult(int status,String message){
        BaseResult result=new BaseResult();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }
}
