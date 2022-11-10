package com.credence.investment.domain.model;

import com.credence.investment.domain.enums.RolEnum;
import com.credence.investment.domain.enums.StatusEnum;
import com.credence.investment.domain.exception.BadRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Builder
public class User {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
    private static final String INVALID_EMAIL = "El email ingresado es invalido";
    private static final String INVALID_NAME = "El nombre no puede estar vacio";
    private static final String INVALID_LASTNAME = "El apellido no puede estar vacio";
    private static final String INVALID_PHONE = "El telefono ingresado no es valido";
    private static final String INVALID_PASSWORD= "la contraseña no puede estar vacia";
    private static final int LENGHT_CELPHONE_NUMBER = 10;
    private static final int LENGHT_PHONE_NUMBER = 7;

    private String id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private RolEnum rol;
    private StatusEnum status;

    @JsonIgnore
    private String password;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void isValid() {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(email);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        Matcher phoneMatcher = emailPattern.matcher(phone);
        StringBuilder erros = new StringBuilder();

        if(email != null && !emailMatcher.matches()) {
            erros.append(INVALID_EMAIL).append("\n");
        }

        if(phone != null && !phoneMatcher.matches()){
            erros.append(INVALID_LASTNAME).append("\n");
        }

        if(name == null || name.isBlank()){
            erros.append(INVALID_NAME).append("\n");
        }

        if(lastname == null || lastname.isBlank()){
            erros.append(INVALID_LASTNAME).append("\n");
        }

        if(password == null || password.isBlank()) {
            erros.append(INVALID_LASTNAME).append("\n");
        }

        if(!erros.isEmpty()) {
            throw new BadRequest(erros.toString());
        }
    }
}
