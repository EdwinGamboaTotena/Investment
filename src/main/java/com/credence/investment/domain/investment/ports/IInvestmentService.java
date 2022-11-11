package com.credence.investment.domain.investment.ports;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;

public interface IInvestmentService {

    PaginatorDto<Investment> getInvestments(int page, int size);

    Investment getInvestmentById(String id);

    Investment createInvestment(CreateInvestmentDto createInvestmentDto);

    void updateInvestment(String id, UpdateInvestmentDto updateInvestmentDto);

    void changeStatus(String id, boolean status);
}
