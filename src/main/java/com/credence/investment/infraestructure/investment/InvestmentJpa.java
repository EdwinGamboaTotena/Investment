package com.credence.investment.infraestructure.investment;

import com.credence.investment.domain.common.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface InvestmentJpa extends JpaRepository<InvestmentEntity, UUID> {

    @Query(value = "UPDATE InvestmentEntity investment SET investment.status = :status WHERE investment.id = :id")
    void changeStatus(UUID id, StatusEnum status);
}
