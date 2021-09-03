package com.usercrud.common.error.code;

import lombok.Getter;

@Getter
public enum  ErrorCode {


    //USER
    NOT_FOUND_USER(400,"U004001","해당 계정을 찾을 수 없습니다."),
    INVALID_EMAIL_FORMAT(400,"U004002","이메일 형식으로 입력해주세요."),
    EXIST_EMAIL(400,"U004003","이미 존재하는 이메일입니다.");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
