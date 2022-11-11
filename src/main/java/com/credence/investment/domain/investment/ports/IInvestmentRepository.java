package com.credence.investment.domain.investment.ports;

import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.investment.Investment;
import org.springframework.data.domain.Page;

import java.util.UUID;


public interface IInvestmentRepository {

    Page<Investment> getInvestmentsList(int page, int size);

    Investment getInvestmentsById(UUID id);

    Investment createInvestments(Investment investment);

    void updateInvestments(Investment investment);

    void changeStatus(UUID id, StatusEnum status);
}