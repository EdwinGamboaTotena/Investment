package com.credence.investment.domain.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginatorDto<T> {

    private List<T> content;
    private int totalPages;
    private long totalElements;
}
