package com.credence.investment.infraestructure.dao.jpa;

import com.credence.investment.infraestructure.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvestmentJpa extends JpaRepository<InvestmentEntity, UUID> {
}
