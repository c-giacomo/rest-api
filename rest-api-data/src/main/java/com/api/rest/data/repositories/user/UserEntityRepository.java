package com.api.rest.data.repositories.user;

import com.api.rest.data.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
