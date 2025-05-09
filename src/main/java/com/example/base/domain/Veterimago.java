package com.example.base.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Veterimago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Enumerated(EnumType.STRING)
    private EstadoVet estado;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Tipo> especialidades;

    @OneToMany(mappedBy = "veterimagoAsignado")
    private List<Cita> citas;}