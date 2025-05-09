package com.example.base.event;

public class UserDeletedEvent {
    private final Long userId;
    private final String email;

    public UserDeletedEvent(Long userId,String email) {
        this.userId = userId;
        this.email = email;}

    public Long getUserId() {
        return userId;}

    public String getEmail() {
        return email;}}