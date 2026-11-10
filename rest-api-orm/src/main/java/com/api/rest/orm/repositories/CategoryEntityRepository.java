package com.api.rest.orm.repositories;

import com.api.rest.orm.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
}
