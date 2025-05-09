package com.example.base.listener;

import com.example.base.event.WelcomeEmailEvent;
import com.example.base.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {

    private final EmailService emailService;

    public WelcomeEmailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    @Async
    public void sendWelcomeEmail(WelcomeEmailEvent welcomeEmailEvent) {
        try {
            Thread.sleep(10000);}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("thread was interrupted", e);}
        emailService.sendEmail(welcomeEmailEvent.getEmail(), "bienvenido", "hola " + welcomeEmailEvent.getEmail() + ", bienvenido a veterimagia");}}