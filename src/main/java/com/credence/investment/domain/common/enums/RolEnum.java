package com.credence.investment.domain.common.enums;

public enum RolEnum {
    SUPER_ADMIN("Super Administrador"),
    EMPLOYEE("Gestor"),
    INVESTOR("Inversionista"),
    SUPPORT("Soporte");

    private String value;

    private RolEnum(String value) {
        this.value = value;
    }
}
