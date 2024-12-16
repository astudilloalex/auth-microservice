package com.alexastudillo.domain.repository;

import java.util.List;

import com.alexastudillo.domain.entity.Provider;

public interface ProviderRepository {
   public List<Provider> findAll(Boolean active);
}
