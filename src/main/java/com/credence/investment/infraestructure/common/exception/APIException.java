package com.credence.investment.infraestructure.common.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class APIException {
    private String excepcion;
    private String mensaje;
}
