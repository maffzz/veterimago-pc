package com.example.base.service;

import com.example.base.domain.Veterimago;
import com.example.base.repository.VeterimagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterimagoService {
    private final VeterimagoRepository veterimagoRepository;

    public Veterimago crearVeterimago(Veterimago veterimago) {
        return veterimagoRepository.save(veterimago);}

    public List<Veterimago> getVeterimagos() {
        return veterimagoRepository.findAll();}}