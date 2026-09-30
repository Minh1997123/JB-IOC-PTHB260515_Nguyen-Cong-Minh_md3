package com.example.jbiocpthb260515_nguyencongminh.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse<T> {
    private Boolean success;
    private String message;
    private T data;
    private Integer httpStatus;
}
