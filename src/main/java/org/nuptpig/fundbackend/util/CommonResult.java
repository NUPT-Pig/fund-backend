package org.nuptpig.fundbackend.util;

import lombok.Data;

@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    private CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, ResultCode resultCode){
        return new CommonResult<T>(resultCode.getCode(), resultCode.getMessage(), data);
    }
}
