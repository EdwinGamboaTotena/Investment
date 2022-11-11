package com.credence.investment.infraestructure.investment;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.ports.IInvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class InvestmentRepository implements IInvestmentRepository {

    public static final String INVESTMENT_NOT_FOUND = "No se encontro la inversion con el id ingresado";

    @Autowired
    private InvestmentJpa jpa;

    @Override
    public Page<Investment> getInvestments(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<InvestmentEntity> investmentEntities = jpa.findAll(paging);
        return InvestmentFactory.entityToModel(investmentEntities);
    }

    @Override
    public Investment getInvestmentsById(UUID id) {
        InvestmentEntity entity = jpa.findById(id)
                .orElseThrow(() -> new BadRequest(INVESTMENT_NOT_FOUND));
        return InvestmentFactory.entityToModel(entity);
    }

    @Override
    public Investment createInvestments(Investment investment) {
        InvestmentEntity entity = InvestmentFactory.modelToEntity(investment);
        entity = jpa.save(entity);
        return InvestmentFactory.entityToModel(entity);
    }

    @Override
    public void updateInvestments(Investment investment) {
        InvestmentEntity entity = InvestmentFactory.modelToEntity(investment);
        jpa.save(entity);
    }

    @Override
    public void changeStatus(UUID id, boolean status) {
        jpa.changeStatus(id, status);
    }
}
