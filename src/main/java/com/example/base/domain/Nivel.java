package com.example.base.domain;

public enum Nivel {APRENDIZ, MAESTRO;

    public static boolean contiene(String valor) {
        for (Nivel e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}