package com.example.base.domain;

public enum EstadoVet {LIBRE, OCUPADO;

    public static boolean contiene(String valor) {
        for (EstadoVet e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}