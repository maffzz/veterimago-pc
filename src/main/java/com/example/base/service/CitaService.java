package com.example.base.service;

import com.example.base.domain.Cita;
import com.example.base.domain.EstadoCit;
import com.example.base.domain.Nivel;
import com.example.base.domain.Veterimago;
import com.example.base.exception.BadRequest;
import com.example.base.exception.Conflict;
import com.example.base.exception.NotFound;
import com.example.base.repository.CitaRepository;
import com.example.base.repository.VeterimagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CitaService {
    private final CitaRepository citaRepository;
    private final VeterimagoRepository veterimagoRepository;

    public Cita crearCita(Cita cita){
        return citaRepository.save(cita);}

    public Cita asignarCita(Long id, Long veterimagoId) {
        Cita cita = citaRepository.findById(id).orElseThrow(
                () -> new NotFound("cita no encontrada con id " + id));
        Veterimago vet = veterimagoRepository.findById(veterimagoId).orElseThrow(
                () -> new NotFound("veterimago no encontrado con id " + veterimagoId));
        if (!vet.getEstado().toString().equalsIgnoreCase("LIBRE")) {
            throw new Conflict("el veterimago no está libre :c");}
        if (!(cita.getTipo() == vet.getEspecialidades().get(0)) || !(cita.getTipo() == vet.getEspecialidades().get(1))) {
            throw new BadRequest("el tipo de cita no es el correspondiente al veterimago");}

        Set<EstadoCit> estadosActivos = EnumSet.of(
                EstadoCit.PENDIENTE,
                EstadoCit.ASIGNADA,
                EstadoCit.EN_PROCESO);
        if (vet.getNivel() == Nivel.APRENDIZ) {
            long activas = vet.getCitas().stream()
                    .filter(c -> estadosActivos.contains(c.getEstado()))
                    .count();
            if (activas >= 2) {
                throw new Conflict("un veterimago APRENDIZ no puede tener más de 2 citas activas");}}
        vet.getCitas().add(cita);
        return cita;}

    public List<Cita> getCitas() {
        return citaRepository.findAll();}

    public Cita cambiarEstado(Long id, String estado) {
        Cita cita = citaRepository.findById(id).orElseThrow(
                () -> new NotFound("cita no encontrada con id " + id));
        if (!EstadoCit.contiene(estado)) {
            throw new BadRequest("estado no válido: " + estado);}
        EstadoCit estadoCit = EstadoCit.valueOf(estado.toUpperCase());
        cita.setEstado(estadoCit);
        return citaRepository.save(cita);}}