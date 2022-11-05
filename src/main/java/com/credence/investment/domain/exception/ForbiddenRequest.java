package com.credence.investment.domain.exception;

public class ForbiddenRequest extends RuntimeException {

    public ForbiddenRequest(String message) {
        super(message);
    }
}