package com.alexastudillo.domain.repository;

import com.alexastudillo.domain.entity.ApiKey;

public interface ApiKeyRepository {
    public ApiKey findByKey(String key);
}
