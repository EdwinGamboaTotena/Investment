package com.credence.investment.domain.investment;

import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.common.formater.StringFormater;
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
public class Investment {

    private String id;
    private User owner;
    private double amount;
    private String currency;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int periodInMonths;
    private int percentagePerMoth;
    private boolean isCompoundInterest;
    private String note;
    private StatusEnum status;

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
}
