package com.credence.investment.domain.investment;

import com.credence.investment.domain.common.formater.StringFormater;
import com.credence.investment.domain.payment.Payment;
import com.credence.investment.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Investment {

    private String id;
    private User owner;
    private double amount;
    private String currency;
    private int periodInMonths;
    private int percentagePerMoth;
    private boolean isCompoundInterest;
    private String note;
    private boolean isActive;

    private List<Payment> payments;

    private User createBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void setCurrency(String currency) {
        this.currency = StringFormater.trimp(currency);
    }

    public void setNote(String note) {
        this.note = StringFormater.trimp(note);
    }

    public void setOwner(String ownerId) {
        if (this.owner == null) {
            this.owner = User.builder()
                    .id(ownerId)
                    .build();
        } else {
            this.owner.setId(ownerId);
        }
    }

    public void addPayment(Payment payment) {
        if(payments == null) {
            payments = new ArrayList<>();
        }
        payments.add(payment);
    }
}
