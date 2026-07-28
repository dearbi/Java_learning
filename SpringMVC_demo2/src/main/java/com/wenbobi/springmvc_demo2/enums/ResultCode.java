package com.wenbobi.springmvc_demo2.enums;

import com.wenbobi.springmvc_demo2.model.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200),
    FAIL(-2),
    UNLOGIN(-1);
    private int code;

    public static Result unlogin(){
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN.getCode());
        result.setErrMsg("用户未登录");
        return result;
    }
    public static <T> Result success(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setErrMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result fail(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultCode.FAIL.getCode());
        result.setErrMsg("fail");
        result.setData(data);
        return result;
    }
}
