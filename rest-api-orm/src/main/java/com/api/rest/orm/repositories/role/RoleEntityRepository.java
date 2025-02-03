package com.api.rest.orm.repositories.role;

import com.api.rest.orm.entities.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
