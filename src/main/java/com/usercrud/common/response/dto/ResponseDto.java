package com.usercrud.common.response.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {
    private int status;
    private String message;
    private String data;
    private LocalDateTime timestamp;

    @Builder
    public ResponseDto(HttpStatus httpStatus, String data){
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
