package com.credence.investment.infraestructure.payment;

import com.credence.investment.domain.payment.PaymentStatusEnum;
import com.credence.investment.infraestructure.investment.InvestmentEntity;
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
@Table(name = "payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column()
    private double amount;

    @Column(nullable = false, length = 5)
    private String currency;

    @Column()
    private boolean isAddedToCapital;

    @Column()
    private String note;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity createBy;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column()
    private LocalDateTime updateAt;
}
