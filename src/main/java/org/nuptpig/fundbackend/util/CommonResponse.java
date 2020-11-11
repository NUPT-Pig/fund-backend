package org.nuptpig.fundbackend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse {
    public static <T> ResponseEntity<CommonResult<T>> ok(T data){
        return ResponseEntity.status(HttpStatus.OK).body(CommonResult.success(data));
    }

    public static <T> ResponseEntity<CommonResult<T>> ok(HttpStatus httpStatus){
        return ResponseEntity.status(httpStatus).body(CommonResult.success(null));
    }

    public static <T> ResponseEntity<CommonResult<T>> ok(HttpStatus httpStatus, ResultCode code, T data){
        return ResponseEntity.status(httpStatus).body(CommonResult.success(data, code));
    }

    public static <T> ResponseEntity<CommonResult<T>> fail(T data){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResult.fail(data));
    }

    public static <T> ResponseEntity<CommonResult<T>> fail(HttpStatus httpStatus){
        return ResponseEntity.status(httpStatus).body(CommonResult.fail(null));
    }

    public static <T> ResponseEntity<CommonResult<T>> fail(HttpStatus httpStatus, ResultCode code, T data){
        return ResponseEntity.status(httpStatus).body(CommonResult.fail(data, code));
    }
}
