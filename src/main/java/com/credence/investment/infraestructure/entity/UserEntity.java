package com.credence.investment.infraestructure.entity;

import com.credence.investment.domain.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 10)
    private String phone;

    @ManyToOne(optional = false)
    private RolEntity rol;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
