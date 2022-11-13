package com.credence.investment.infraestructure.payment;

import com.credence.investment.domain.payment.Payment;
import com.credence.investment.infraestructure.investment.InvestmentMapper;
import com.credence.investment.infraestructure.user.UserMapper;
import org.springframework.data.domain.Page;

import java.util.UUID;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static final Page<Payment> entityToModel(Page<PaymentEntity> page) {
        return page.map(p -> entityToModel(p));
    }

    public static final Payment entityToModel(PaymentEntity entity) {
        if (entity == null) return null;
        Payment model = Payment.builder()
                .id(entity.getId().toString())
                .investment(InvestmentMapper.entityToModel(entity.getInvestment()))
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .isAddedToCapital(entity.isAddedToCapital())
                .note(entity.getNote())
                .status(entity.getStatus())
                .createBy(UserMapper.entityToModel(entity.getCreateBy()))
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .build();

        return model;
    }

    public static final PaymentEntity modelToEntity(Payment model) {
        if (model == null) return null;
        PaymentEntity entity = PaymentEntity.builder()
                .investment(InvestmentMapper.modelToEntity(model.getInvestment()))
                .amount(model.getAmount())
                .currency(model.getCurrency())
                .isAddedToCapital(model.isAddedToCapital())
                .note(model.getNote())
                .status(model.getStatus())
                .createBy(UserMapper.modelToEntity(model.getCreateBy()))
                .createAt(model.getCreateAt())
                .updateAt(model.getUpdateAt())
                .build();

        if (model.getId() != null && !model.getId().isBlank()) {
            entity.setId(UUID.fromString(model.getId()));
        }

        return entity;
    }
}
