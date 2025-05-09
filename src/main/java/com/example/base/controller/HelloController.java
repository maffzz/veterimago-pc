package com.example.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("hola mundo", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> helloUser(Principal principal) {
        return new ResponseEntity<>("hola " + principal.getName(), HttpStatus.OK);}}