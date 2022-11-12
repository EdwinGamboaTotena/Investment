package com.credence.investment.domain.payment;

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

    private String id;
    private Investment investment;
    private double amount;
    private String currency;
    private boolean isAddedToCapital;
    private String note;
    private PaymentStatusEnum status;

    private User createBy;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void isValid() {

    }
}
