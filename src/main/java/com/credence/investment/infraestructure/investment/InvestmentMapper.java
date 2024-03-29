package com.credence.investment.infraestructure.investment;

import com.credence.investment.domain.investment.Investment;
import com.credence.investment.infraestructure.user.UserMapper;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class InvestmentMapper {

    private InvestmentMapper() {
    }

    public static final Page<Investment> entityToModel(Page<InvestmentEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final Investment entityToModel(InvestmentEntity entity) {
        if (entity == null) return null;
        Investment model = Investment.builder()
                .id(entity.getId().toString())
                .owner(UserMapper.entityToModel(entity.getOwner()))
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .periodInMonths(entity.getPeriodInMonths())
                .percentagePerMoth(entity.getPercentagePerMoth())
                .isCompoundInterest(entity.isCompoundInterest())
                .note(entity.getNote())
                .isActive(entity.isActive())
                .createBy(UserMapper.entityToModel(entity.getCreateBy()))
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();

        return model;
    }

    public static final InvestmentEntity modelToEntity(Investment model) {
        if (model == null) return null;

        InvestmentEntity entity = InvestmentEntity.builder()
                .owner(UserMapper.modelToEntity(model.getOwner()))
                .amount(model.getAmount())
                .currency(model.getCurrency())
                .periodInMonths(model.getPeriodInMonths())
                .percentagePerMoth(model.getPercentagePerMoth())
                .isCompoundInterest(model.isCompoundInterest())
                .note(model.getNote())
                .isActive(model.isActive())
                .createBy(UserMapper.modelToEntity(model.getCreateBy()))
                .createDate(model.getCreateDate())
                .updateDate(model.getUpdateDate())
                .build();


        if (model.getId() != null && !model.getId().isBlank()) {
            entity.setId(UUID.fromString(model.getId()));
        }

        return entity;
    }
}
