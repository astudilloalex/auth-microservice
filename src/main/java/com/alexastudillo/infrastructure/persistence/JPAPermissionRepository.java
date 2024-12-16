package com.alexastudillo.infrastructure.persistence;

import java.util.List;

import com.alexastudillo.domain.entity.Permission;
import com.alexastudillo.domain.repository.PermissionRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JPAPermissionRepository implements PermissionRepository, PanacheRepository<Permission> {

    @Override
    public List<Permission> findAllPagedKeyset(Boolean active, String lastCode, int size) {
        if (lastCode == null) {
            if (active == null) {
                return find("ORDER BY code ASC").page(0, size).list();
            }
            return find("active = ?1 ORDER BY code ASC", active).page(0, size).list();
        }
        if (active == null) {
            return find("code > ?1 ORDER BY code ASC", lastCode).page(0, size).list();
        }
        return find("code > ?1 AND active = ?2 ORDER BY code ASC", lastCode, active).page(0, size).list();
    }

    @Override
    public long count(Boolean active) {
        if(active==null){
            return count();
        }
        return count("active = ?1", active);
    }

}
