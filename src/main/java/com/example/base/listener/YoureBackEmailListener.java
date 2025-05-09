package com.example.base.listener;

import com.example.base.event.YoureBackEmailEvent;
import com.example.base.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class YoureBackEmailListener {

    private final EmailService emailService;

    public YoureBackEmailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    @Async
    public void sendYoureBackEmail(YoureBackEmailEvent youreBackEmailEvent) {
        try {
            Thread.sleep(10000);}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("thread was interrupted", e);}
        emailService.sendEmail(youreBackEmailEvent.getEmail(), "volviste", "hola " + youreBackEmailEvent.getEmail() + ", volviste a veterimagia");}}