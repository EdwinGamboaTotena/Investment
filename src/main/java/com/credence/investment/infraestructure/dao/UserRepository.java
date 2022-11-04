package com.credence.investment.infraestructure.dao;

import com.credence.investment.domain.dao.IUserRepository;
import com.credence.investment.infraestructure.dao.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepository implements IUserRepository {

    @Autowired
    private UserJpa jpa;
}
