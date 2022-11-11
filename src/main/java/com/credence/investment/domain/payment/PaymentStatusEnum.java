package com.credence.investment.domain.payment;

public enum PaymentStatusEnum {
    TO_PAY("Por pagar"),
    PAID("Pagado");

    private String value;

    private PaymentStatusEnum(String value) {
        this.value = value;
    }
}
