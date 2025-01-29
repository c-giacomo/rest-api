package com.api.rest.data.repositories.role;

import com.api.rest.data.entities.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
