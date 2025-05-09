package com.example.base.dto;

public class SigninRequest {
    private String email;
    private String password;

    public SigninRequest() {}

    public SigninRequest(String email, String password) {
        this.email = email;
        this.password = password;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }}