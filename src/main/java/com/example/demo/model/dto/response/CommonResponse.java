package com.example.demo.model.dto.response;

import lombok.Data;

@Data
public class CommonResponse {
    private int status;
    private String message;
    private Object data;


}
