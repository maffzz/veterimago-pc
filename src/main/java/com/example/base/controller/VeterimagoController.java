package com.example.base.controller;

import com.example.base.domain.Veterimago;
import com.example.base.service.VeterimagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veterimagos")
@RequiredArgsConstructor
public class VeterimagoController {
    private final VeterimagoService veterimagoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Veterimago> crearVeterimago(Veterimago veterimago) {
        Veterimago newVeterimago = veterimagoService.crearVeterimago(veterimago);
        URI location = URI.create("/veterimagos/" + newVeterimago.getId());
        return ResponseEntity.created(location).build();}

    @PreAuthorize("hasAnyRole('ADMIN', 'VETERIMAGO')")
    @GetMapping
    public List<Veterimago> getVeterimagos() {
        return veterimagoService.getVeterimagos();}}