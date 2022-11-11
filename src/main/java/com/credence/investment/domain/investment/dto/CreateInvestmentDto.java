package com.credence.investment.domain.investment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateInvestmentDto {

    private String owner;
    private double amount;
    private String currency;
    private int periodInMonths;
    private int percentagePerMoth;
    private boolean isCompoundInterest;
    private String note;

}
