package com.credence.investment.infraestructure.common.exception;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.common.exception.ForbiddenRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR =
            "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> STATUS_CODE = new ConcurrentHashMap<>();

    public HandlerException() {
        STATUS_CODE.put(BadRequest.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(ForbiddenRequest.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<APIException> handleAllExceptions(Exception exception) {
        ResponseEntity<APIException> result;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = STATUS_CODE.get(excepcionNombre);
        if (codigo != null) {
            APIException error = new APIException(excepcionNombre, mensaje);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            APIException error = new APIException(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LOGGER.error("{}", exception);
        return result;
    }
}
