package com.credence.investment.infraestructure.entity;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class InvestmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false)
    private UserEntity owner;

    @Column()
    private double amount;

    @Column(nullable = false, length = 5)
    private String currency;

    @Column()
    private boolean isActive = true;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column()
    private LocalDate updateDate;

    @Column()
    private int periodInMonths;

    @Column()
    private int percentage;

    @Column()
    private boolean isCompoundInterest;

    @Column()
    private String note;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
