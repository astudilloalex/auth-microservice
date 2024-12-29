package com.alexastudillo.domain.security;

public interface PasswordHasher {
    String hash(String password);

    boolean verify(String password, String hashedPassword);
}
