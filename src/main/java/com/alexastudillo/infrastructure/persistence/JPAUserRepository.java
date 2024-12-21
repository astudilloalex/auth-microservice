package com.alexastudillo.infrastructure.persistence;

import com.alexastudillo.domain.entity.User;
import com.alexastudillo.domain.repository.UserRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JPAUserRepository implements UserRepository, PanacheRepository<User> {

    @Override
    public User findByEmail(String email) {
        return find("email", email).firstResult();
    }

    @Override
    public User findByUsername(String username) {
        return find("username", username).firstResult();
    }

    @Override
    public User findByCode(String code) {
        return find("code", code).firstResult();
    }

    @Override
    public User save(User user) {
        persist(user);
        return user;
    }

    @Override
    public User update(User user) {
       return update(user);
    }

}
