package com.credence.investment.domain.payment;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.common.formater.StringFormater;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    public static final String INVALID_AMOUNT = "El monto no puede ser negatico";

    private String id;
    private double amount;
    private String currency;
    private boolean isAddedToCapital;
    private String note;
    private PaymentStatusEnum status;

    private User createBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void setCurrency(String currency) {
        this.currency = StringFormater.trimp(currency);
    }

    public void setNote(String note) {
        this.note = StringFormater.trimp(note);
    }

    public void isValid() {
        if(amount < 0) {
            throw new BadRequest(INVALID_AMOUNT);
        }
    }
}
