package com.api.rest.mapper.impl;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.Expense;
import com.api.rest.model.Product;
import com.api.rest.orm.entities.ExpenseEntity;
import com.api.rest.orm.entities.ExpenseProductEntity;
import com.api.rest.orm.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {ProductMapper.class,}
)
public interface ExpenseMapper extends BaseMapper<ExpenseEntity, Expense> {

    @Override
    @Mapping(target = "product", source = "expenseProducts")
    @Mapping(target = "user", source = "user")
    Expense map(ExpenseEntity entity);

    default Product map(ExpenseProductEntity entity) {
        return entity == null ? null : map(entity.getProduct());
    }

    Product map(ProductEntity entity);
}
