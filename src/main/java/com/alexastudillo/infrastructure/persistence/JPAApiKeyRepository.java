package com.alexastudillo.infrastructure.persistence;

import com.alexastudillo.domain.entity.ApiKey;
import com.alexastudillo.domain.repository.ApiKeyRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JPAApiKeyRepository implements ApiKeyRepository, PanacheRepository<ApiKey> {

    @Override
    public ApiKey findByKey(String key) {
        return find("key", key).firstResult();
    }
}
