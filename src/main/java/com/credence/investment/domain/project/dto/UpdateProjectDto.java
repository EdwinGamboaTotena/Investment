package com.credence.investment.domain.project.dto;

import com.credence.investment.domain.project.ProjectStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UpdateProjectDto {
    private String name;
    private String description;
    private String url;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
    private ProjectStatusEnum status;
}
