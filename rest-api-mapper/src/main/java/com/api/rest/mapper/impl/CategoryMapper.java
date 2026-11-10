package com.api.rest.mapper.impl;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.Category;
import com.api.rest.orm.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoryEntity, Category> {
}
