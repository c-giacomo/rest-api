package com.api.rest.orm.repositories;

import com.api.rest.orm.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}
