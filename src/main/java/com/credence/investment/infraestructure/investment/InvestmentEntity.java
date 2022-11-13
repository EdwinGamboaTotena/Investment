package com.credence.investment.infraestructure.investment;

import com.credence.investment.infraestructure.payment.PaymentEntity;
import com.credence.investment.infraestructure.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "investments")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity createBy;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column()
    private LocalDateTime updateAt;

}
