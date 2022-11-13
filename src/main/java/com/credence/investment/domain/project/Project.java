package com.credence.investment.domain.project;

import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.common.formater.StringFormater;
import com.credence.investment.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private static final String INVALID_NAME = "El nombre no puede estar vacio";

    private String id;
    private String name;
    private String description;
    private String url;
    private double amountUsed;
    private int expectedPercentage;
    private String currencyUsed;
    private ProjectStatusEnum status;

    private User createBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void setName(String name) {
        this.name = StringFormater.trimp(name);
    }

    public void setDescription(String description) {
        this.description = StringFormater.trimp(description);
    }

    public void setUrl(String url) {
        this.url = StringFormater.trimp(url);
    }

    public void setCurrencyUsed(String currencyUsed) {
        this.currencyUsed = StringFormater.trimp(currencyUsed);
    }

    public void isValid() {
        if (name == null || name.isBlank()) {
            throw new BadRequest(INVALID_NAME);
        }
    }
}
