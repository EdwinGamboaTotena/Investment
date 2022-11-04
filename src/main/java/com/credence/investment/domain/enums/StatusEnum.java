package com.credence.investment.domain.enums;

public enum StatusEnum {
    ACTIVE("Activo"),
    DISABLED("Desactivado"),
    REVIEW("En revision"),
    STOP("Pausado");

    private String value;

    private StatusEnum(String value){
        this.value=value;
    }
}