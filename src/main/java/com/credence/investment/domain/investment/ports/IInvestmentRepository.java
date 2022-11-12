package com.credence.investment.domain.investment.ports;

import com.credence.investment.domain.investment.Investment;
import org.springframework.data.domain.Page;

import java.util.UUID;


public interface IInvestmentRepository {

    Page<Investment> get(int page, int size);

    Investment getById(UUID id);

    Investment create(Investment investment);

    void update(Investment investment);

    void changeStatus(UUID id, boolean status);
}
