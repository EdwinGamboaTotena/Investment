package com.credence.investment.infraestructure.investment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface InvestmentJpa extends JpaRepository<InvestmentEntity, UUID> {

    @Query(value = "UPDATE InvestmentEntity investment SET investment.isActive = :status WHERE investment.id = :id")
    void changeStatus(UUID id, boolean status);
}
