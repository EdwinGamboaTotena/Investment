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
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false)
    private InvestmentEntity investment;

    @Column()
    private double amount;

    @Column(nullable = false, length = 5)
    private String currency;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column()
    private LocalDate updateDate;

    @Column()
    private boolean isAddedToCapital;

    @Column()
    private String note;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
