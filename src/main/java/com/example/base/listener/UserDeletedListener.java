package com.example.base.listener;

import com.example.base.event.UserDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserDeletedListener {
    @Async
    @EventListener
    public void handleUserDeletedEvent(UserDeletedEvent event) {
        System.out.println("[ASYNC] usuario eliminado: " + event.getUserId());}}