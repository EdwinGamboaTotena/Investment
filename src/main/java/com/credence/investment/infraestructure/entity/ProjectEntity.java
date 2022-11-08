package com.credence.investment.infraestructure.entity;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
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
