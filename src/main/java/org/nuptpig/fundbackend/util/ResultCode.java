package org.nuptpig.fundbackend.util;


public enum ResultCode {
    SUCCESS(200, "成功");
    private long code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
