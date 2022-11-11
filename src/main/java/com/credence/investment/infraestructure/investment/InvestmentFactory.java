package com.credence.investment.infraestructure.investment;

import com.credence.investment.domain.investment.Investment;
import com.credence.investment.infraestructure.user.UserFactory;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class InvestmentFactory {

    private InvestmentFactory() {
    }

    public static final Page<Investment> entityToModel(Page<InvestmentEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final Investment entityToModel(InvestmentEntity entity) {
        if (entity == null) return null;
        Investment model = Investment.builder()
                .id(entity.getId().toString())
                .owner(UserFactory.entityToModel(entity.getOwner()))
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .periodInMonths(entity.getPeriodInMonths())
                .percentagePerMoth(entity.getPercentagePerMoth())
                .isCompoundInterest(entity.isCompoundInterest())
                .note(entity.getNote())
                .isActive(entity.isActive())
                .build();

        return model;
    }

    public static final InvestmentEntity modelToEntity(Investment model) {
        if (model == null) return null;

        InvestmentEntity entity = InvestmentEntity.builder()
                .owner(UserFactory.modelToEntity(model.getOwner()))
                .amount(model.getAmount())
                .currency(model.getCurrency())
                .createDate(model.getCreateDate())
                .updateDate(model.getUpdateDate())
                .periodInMonths(model.getPeriodInMonths())
                .percentagePerMoth(model.getPercentagePerMoth())
                .isCompoundInterest(model.isCompoundInterest())
                .note(model.getNote())
                .isActive(model.isActive())
                .build();


        if (model.getId() != null && !model.getId().isBlank()) {
            entity.setId(UUID.fromString(model.getId()));
        }

        return entity;
    }
}
