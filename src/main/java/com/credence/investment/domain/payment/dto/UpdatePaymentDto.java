package com.credence.investment.domain.payment.dto;

import com.credence.investment.domain.payment.PaymentStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatePaymentDto {
    private double amount;
    private String currency;
    private boolean isAddedToCapital;
    private String note;
    private PaymentStatusEnum status;
}
