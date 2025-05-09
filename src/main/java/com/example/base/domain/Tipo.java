package com.example.base.domain;

public enum Tipo {MEDICINA, PELUQUERIA;

    public static boolean contiene(String valor) {
        for (Tipo e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}
