package com.credence.investment.infraestructure.persistence.jpa;

import com.credence.investment.infraestructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PaymentJpa extends JpaRepository<PaymentEntity, UUID> {
}
