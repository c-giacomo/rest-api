package com.api.rest.service;

import com.api.rest.mapper.impl.ExpenseMapper;
import com.api.rest.model.Expense;
import com.api.rest.orm.entities.ExpenseEntity;
import com.api.rest.orm.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService extends AbstractService<Long, ExpenseRepository, ExpenseMapper, ExpenseEntity, Expense> {

    public ExpenseService(ExpenseMapper mapper, ExpenseRepository repository) {
        super(mapper, repository);
    }


}
