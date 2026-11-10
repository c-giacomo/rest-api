package com.api.rest.service;

import com.api.rest.mapper.impl.CategoryMapper;
import com.api.rest.model.Category;
import com.api.rest.orm.entities.CategoryEntity;
import com.api.rest.orm.repositories.CategoryEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Long, CategoryEntityRepository, CategoryMapper, CategoryEntity, Category> {

    public CategoryService(CategoryMapper mapper, CategoryEntityRepository repository) {
        super(mapper, repository);
    }
}
