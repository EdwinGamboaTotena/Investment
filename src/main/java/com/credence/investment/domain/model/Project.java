package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.StatusEnum;

import java.util.UUID;

public class Project {

    private UUID id;
    private String name;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
    private StatusEnum status;
}
