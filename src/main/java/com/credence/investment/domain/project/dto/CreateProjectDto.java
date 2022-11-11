package com.credence.investment.domain.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProjectDto {
    private String name;
    private String description;
    private String url;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
}
