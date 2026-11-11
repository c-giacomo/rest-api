package com.api.rest.orm.repositories;

import com.api.rest.orm.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
