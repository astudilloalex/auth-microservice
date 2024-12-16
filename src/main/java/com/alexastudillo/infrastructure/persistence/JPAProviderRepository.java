package com.alexastudillo.infrastructure.persistence;

import java.util.List;

import com.alexastudillo.domain.entity.Provider;
import com.alexastudillo.domain.repository.ProviderRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JPAProviderRepository implements ProviderRepository, PanacheRepository<Provider> {

    @Override
    public List<Provider> findAll(Boolean active) {
        if (active == null) {
            return listAll();
        }
        return list("active", active);
    }
}
