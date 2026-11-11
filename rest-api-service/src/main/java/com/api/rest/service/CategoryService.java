package com.api.rest.service;

import com.api.rest.mapper.impl.CategoryMapper;
import com.api.rest.model.Category;
import com.api.rest.orm.entities.CategoryEntity;
import com.api.rest.orm.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Long, CategoryRepository, CategoryMapper, CategoryEntity, Category> {

    public CategoryService(CategoryMapper mapper, CategoryRepository repository) {
        super(mapper, repository);
    }
}
