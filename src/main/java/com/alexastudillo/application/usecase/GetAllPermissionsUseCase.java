package com.alexastudillo.application.usecase;

import java.util.List;

import com.alexastudillo.application.response.PagedApiResponse;
import com.alexastudillo.application.response.ResponseCode;
import com.alexastudillo.domain.entity.Permission;
import com.alexastudillo.domain.repository.PermissionRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetAllPermissionsUseCase {
    private final PermissionRepository permissionRepository;

    public GetAllPermissionsUseCase(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public PagedApiResponse<Permission> execute(String lastCode, int size, Boolean active) {
        List<Permission> permissions = permissionRepository.findAllPagedKeyset(active, lastCode, size);
        long totalRecords = permissionRepository.count(active);
        return new PagedApiResponse<>(size, ResponseCode.SUCCESSFUL.getCode(),
                !permissions.isEmpty() && permissions.size() == size, totalRecords, permissions);
    }
}
