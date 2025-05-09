package com.example.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(Principal principal) {
        return ResponseEntity.ok("soy un admin: " + principal.getName());}

    @PreAuthorize("hasRole('VETERIMAGO')")
    @GetMapping("/veterimago")
    public ResponseEntity<String> veterimago(Principal principal) {
        return ResponseEntity.ok("soy un veterimago: " + principal.getName());}

    @PreAuthorize("hasRole('DUENIO')")
    @GetMapping("/duenio")
    public ResponseEntity<String> duenio(Principal principal) {
        return ResponseEntity.ok("soy un duenio: " + principal.getName());}

    @PreAuthorize("hasRole('ADMIN') or hasRole('VETERIMAGO') or hasRole('DUENIO')")
    @GetMapping("/todos")
    public ResponseEntity<String> both(Principal principal) {
        return ResponseEntity.ok("soy cualquiera de los tres roles: " + principal.getName());}}