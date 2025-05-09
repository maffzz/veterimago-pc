package com.example.base.domain;

public enum EstadoCit {PENDIENTE, ASIGNADA, EN_PROCESO, COMPLETADA;

    public static boolean contiene(String valor) {
        for (EstadoCit e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}