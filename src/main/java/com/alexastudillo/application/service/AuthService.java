package com.alexastudillo.application.service;

import com.alexastudillo.application.dto.RegisterWithEmailDTO;
import com.alexastudillo.application.dto.UserDTO;
import com.alexastudillo.domain.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO registerWithEmail(RegisterWithEmailDTO registerWithEmailDTO) {
        return null;
    }
}
