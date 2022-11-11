package com.credence.investment.domain.project;

import com.credence.investment.domain.common.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Project {

    private String id;
    private String name;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
    private StatusEnum status;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
