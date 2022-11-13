package com.credence.investment.infraestructure.payment;

import com.credence.investment.domain.payment.Payment;
import com.credence.investment.domain.payment.port.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PaymentRepository implements IPaymentRepository {

    @Autowired
    private PaymentJpa jpa;

    @Override
    public Page<Payment> get(UUID investmentId, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<PaymentEntity> entities = jpa.findByInvestmentId(investmentId, paging);
        return PaymentMapper.entityToModel(entities);
    }

    @Override
    public Payment getById(UUID id) {
        PaymentEntity entity = jpa.findById(id).orElse(null);
        return PaymentMapper.entityToModel(entity);
    }

    @Override
    public Payment save(Payment model) {
        PaymentEntity entity = PaymentMapper.modelToEntity(model);
        entity = jpa.save(entity);
        return PaymentMapper.entityToModel(entity);
    }

}
