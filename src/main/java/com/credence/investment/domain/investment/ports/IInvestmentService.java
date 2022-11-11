package com.credence.investment.domain.investment.ports;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;

public interface IInvestmentService {

    PaginatorDto<Investment> getInvestmentsList(int page, int size);

    Investment getInvestmentById(String id);

    Investment createInvestment(CreateInvestmentDto createInvestmentDto);

    void updateInvestment(String id, UpdateInvestmentDto updateInvestmentDto);

    void changeStatus(String id, StatusEnum status);
}
