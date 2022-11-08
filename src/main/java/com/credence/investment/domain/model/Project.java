package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Project {

    private String id;
    private String name;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
    private StatusEnum status;
}
