package com.credence.investment.domain.payment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePaymentDto {
    private double amount;
    private String currency;
    private String note;
}
