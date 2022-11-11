package com.credence.investment.domain.user;

import com.credence.investment.domain.common.enums.RolEnum;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.common.formater.StringFormater;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
    private static final String INVALID_EMAIL = "El email ingresado es invalido";
    private static final String INVALID_NAME = "El nombre no puede estar vacio";
    private static final String INVALID_LASTNAME = "El apellido no puede estar vacio";
    private static final String INVALID_PHONE = "El telefono ingresado no es valido";
    private static final String INVALID_PASSWORD = "la contraseña no puede estar vacia";
    private static final int LENGHT_CELPHONE_NUMBER = 10;
    private static final int LENGHT_PHONE_NUMBER = 7;

    private String id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private RolEnum rol;
    private boolean isActive;

    @JsonIgnore
    private String password;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void setName(String name) {
        this.name = StringFormater.trimp(name);
    }

    public void setLastname(String lastname) {
        this.lastname = StringFormater.trimp(lastname);
    }

    public void setEmail(String email) {
        this.email = StringFormater.trimp(email);
    }

    public void setPhone(String phone) {
        this.phone = StringFormater.trimp(phone);
    }

    public void isValid() {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(email);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        StringBuilder erros = new StringBuilder();

        if (email != null && !emailMatcher.matches()) {
            erros.append(INVALID_EMAIL).append("\n");
        }

        if (phone != null && !phoneMatcher.matches()) {
            erros.append(INVALID_PHONE).append("\n");
        }

        if (name == null || name.isBlank()) {
            erros.append(INVALID_NAME).append("\n");
        }

        if (lastname == null || lastname.isBlank()) {
            erros.append(INVALID_LASTNAME).append("\n");
        }

        if (password == null || password.isBlank()) {
            erros.append(INVALID_PASSWORD).append("\n");
        }

        if (!erros.isEmpty()) {
            throw new BadRequest(erros.toString());
        }
    }
}
