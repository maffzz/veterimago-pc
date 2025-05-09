package com.example.base.exception;

import lombok.Data;

@Data
public class Error {
    private String error;
    private String message;
    private int status;
    public Error(String error, String message, int status) {
        this.error = error;
        this.message = message;
        this.status = status;}}