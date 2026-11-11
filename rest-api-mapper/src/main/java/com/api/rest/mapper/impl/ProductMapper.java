package com.api.rest.mapper.impl;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.Product;
import com.api.rest.orm.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductEntity, Product> {

    @Override
    @Mapping(target = "type", ignore = true)
    ProductEntity mapReverse(Product v, @MappingTarget ProductEntity t);
}
