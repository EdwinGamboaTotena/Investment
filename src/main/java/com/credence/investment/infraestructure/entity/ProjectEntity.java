package com.credence.investment.infraestructure.entity;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column()
    private double amountUsed;

    @Column()
    private int expectedPercentage;

    @Column(nullable = false, length = 5)
    private String currencyUsed;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
