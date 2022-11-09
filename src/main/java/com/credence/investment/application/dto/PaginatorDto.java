package com.credence.investment.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PaginatorDto<T> {

    private List<T> content;
    private int totalPages;
    private long totalElements;
}
