package com.example.base.domain;

public enum Role {ADMIN, VETERIMAGO, DUENIO;

    public static boolean contiene(String valor) {
        for (Role e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}