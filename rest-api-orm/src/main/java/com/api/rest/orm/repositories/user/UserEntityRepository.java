package com.api.rest.orm.repositories.user;

import com.api.rest.orm.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
