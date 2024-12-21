package com.alexastudillo.domain.repository;

import com.alexastudillo.domain.entity.User;

public interface UserRepository {
    public User findByEmail(String email);

    public User findByUsername(String username);

    public User findByCode(String code);

    public User save(User user);

    public User update(User user);
}
