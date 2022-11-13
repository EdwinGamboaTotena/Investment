package com.credence.investment.infraestructure.investment;

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

    @Autowired
    private InvestmentJpa jpa;

    @Override
    public Page<Investment> get(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<InvestmentEntity> entities = jpa.findAll(paging);
        return InvestmentMapper.entityToModel(entities);
    }

    @Override
    public Investment getById(UUID id) {
        InvestmentEntity entity = jpa.findById(id).orElse(null);
        return InvestmentMapper.entityToModel(entity);
    }

    @Override
    public Investment save(Investment model) {
        InvestmentEntity entity = InvestmentMapper.modelToEntity(model);
        entity = jpa.save(entity);
        return InvestmentMapper.entityToModel(entity);
    }

    @Override
    public void changeStatus(UUID id, boolean status) {
        jpa.changeStatus(id, status);
    }
}
