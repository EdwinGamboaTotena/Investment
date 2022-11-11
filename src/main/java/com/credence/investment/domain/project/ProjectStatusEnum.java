package com.credence.investment.domain.project;

public enum ProjectStatusEnum {
    ACTIVE("Activo"),
    DISABLED("Desactivado"),
    REVIEW("En revision"),
    STOP("Pausado");

    private String value;

    private ProjectStatusEnum(String value) {
        this.value = value;
    }
}
