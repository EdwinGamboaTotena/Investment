package com.credence.investment.infraestructure.investment;

import com.credence.investment.infraestructure.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity owner;

    @Column()
    private double amount;

    @Column(nullable = false, length = 5)
    private String currency;

    @Column()
    private int periodInMonths;

    @Column()
    private int percentagePerMoth;

    @Column()
    private boolean isCompoundInterest;

    @Column()
    private String note;

    @Column()
    private boolean isActive;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity createBy;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime updateDate;

}
