package com.credence.investment.infraestructure.project;

import com.credence.investment.domain.project.ProjectStatusEnum;
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
public class ProjectEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    private String url;

    @Column()
    private double amountUsed;

    @Column()
    private int expectedPercentage;

    @Column(nullable = false, length = 10)
    private String currencyUsed;

    @Enumerated(EnumType.STRING)
    private ProjectStatusEnum status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity createBy;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime updateDate;
}
