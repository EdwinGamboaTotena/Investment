package com.credence.investment.domain.investment.ports;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;

public interface IInvestmentService {

    PaginatorDto<Investment> get(int page, int size);

    Investment getById(String id);

    Investment create(CreateInvestmentDto createInvestmentDto, String userId);

    void update(String id, UpdateInvestmentDto updateInvestmentDto);

    void changeStatus(String id, boolean status);
}
