package com.credence.investment.domain.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordDto {
    private String id;
    private String newPassword;
}
