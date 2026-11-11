package com.api.rest.service;

import com.api.rest.mapper.impl.ProductMapper;
import com.api.rest.model.Product;
import com.api.rest.orm.entities.CategoryEntity;
import com.api.rest.orm.entities.ProductEntity;
import com.api.rest.orm.repositories.CategoryRepository;
import com.api.rest.orm.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductService extends AbstractService<Long, ProductRepository, ProductMapper, ProductEntity, Product> {

    private final CategoryRepository categoryRepository;

    public ProductService(ProductMapper mapper, ProductRepository repository, CategoryRepository categoryRepository) {
        super(mapper, repository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductEntity enrich(ProductEntity entity, Product product) {
        Long categoryId = Objects.requireNonNull(
                product.getType().getId(),
                "Category id cannot be null."
        );

        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Category with id " + categoryId + " not found."
                ));

        entity.setType(category);
        return entity;
    }

    @Transactional
    public Product switchCategory(Long productId, Long categoryId) {
        ProductEntity productEntity = repository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found."));

        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + categoryId + " not found."));

        productEntity.setType(categoryEntity);
        return mapper.map(productEntity);
    }
}
