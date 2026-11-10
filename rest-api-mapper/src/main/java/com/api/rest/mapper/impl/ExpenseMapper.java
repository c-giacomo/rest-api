package com.api.rest.mapper.impl;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.Expense;
import com.api.rest.orm.entities.ExpenseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper extends BaseMapper<ExpenseEntity, Expense> {
}
