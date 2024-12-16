package com.alexastudillo.application.usecase;

import java.util.List;

import com.alexastudillo.domain.entity.Provider;
import com.alexastudillo.domain.repository.ProviderRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetAllProvidersUseCase {
    private final ProviderRepository providerRepository;
    
    public GetAllProvidersUseCase(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    public List<Provider> execute(Boolean active){
        return providerRepository.findAll(active);
    }
}
