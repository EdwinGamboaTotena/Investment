package com.credence.investment.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaginatorDto {
    private int page;
    private int size;
}
