package com.alexastudillo.domain.repository;

import java.util.List;

import com.alexastudillo.domain.entity.Permission;

public interface PermissionRepository {
    public List<Permission> findAllPagedKeyset(Boolean active, String lastCode, int size);

    public long count(Boolean active);
}
