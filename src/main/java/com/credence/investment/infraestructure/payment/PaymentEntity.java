package com.credence.investment.infraestructure.payment;

import com.credence.investment.domain.payment.PaymentStatusEnum;
import com.credence.investment.infraestructure.investment.InvestmentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private InvestmentEntity investment;

    @Column()
    private double amount;

    @Column(nullable = false, length = 5)
    private String currency;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime updateDate;

    @Column()
    private boolean isAddedToCapital;

    @Column()
    private String note;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;
}
