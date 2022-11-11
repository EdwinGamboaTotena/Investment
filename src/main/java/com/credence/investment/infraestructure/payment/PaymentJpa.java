package com.credence.investment.infraestructure.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PaymentJpa extends JpaRepository<PaymentEntity, UUID> {
}
