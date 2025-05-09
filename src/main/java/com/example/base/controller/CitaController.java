package com.example.base.controller;

import com.example.base.domain.Cita;
import com.example.base.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {
    private final CitaService citaService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('DUENIO')")
    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita newCita = citaService.crearCita(cita);
        URI location = URI.create("/citas/" + newCita.getId());
        return ResponseEntity.created(location).build();}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/asignar/{veterimagoId}")
    public ResponseEntity<Cita> asignarCita(@PathVariable Long id, @PathVariable Long veterimagoId) {
        Cita cita = citaService.asignarCita(id, veterimagoId);
        return ResponseEntity.ok(cita);}

    @PreAuthorize("hasRole('ADMIN') or hasRole('VETERIMAGO') or hasRole('DUENIO')")
    @GetMapping
    public ResponseEntity<List<Cita>> getCitas() {
        return ResponseEntity.ok(citaService.getCitas());}

    @PreAuthorize("hasRole('ADMIN') or hasRole('VETERIMAGO')")
    @PutMapping("/{id}/estado")
    public ResponseEntity<Cita> cambiarEstado(@PathVariable Long id, @RequestBody String estado) {
        Cita cita = citaService.cambiarEstado(id, estado);
        return ResponseEntity.ok(cita);}}