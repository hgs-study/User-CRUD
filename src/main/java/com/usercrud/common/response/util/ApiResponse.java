package com.usercrud.common.response.util;

import com.usercrud.common.response.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
    public static ResponseEntity<ResponseDto> success(HttpStatus status, String data){
        return ResponseEntity.status(status)
                             .body(new ResponseDto(status, data));
    }
}
