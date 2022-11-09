package com.credence.investment.infraestructure.entity;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class InvestmentEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
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
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime updateDate;

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
