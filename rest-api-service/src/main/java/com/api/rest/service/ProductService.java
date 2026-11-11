package com.api.rest.service;

import com.api.rest.mapper.impl.ProductMapper;
import com.api.rest.model.Product;
import com.api.rest.orm.entities.CategoryEntity;
import com.api.rest.orm.entities.ProductEntity;
import com.api.rest.orm.repositories.CategoryEntityRepository;
import com.api.rest.orm.repositories.ProductEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductService extends AbstractService<Long, ProductEntityRepository, ProductMapper, ProductEntity, Product> {

    private final CategoryEntityRepository categoryEntityRepository;

    public ProductService(ProductMapper mapper, ProductEntityRepository repository, CategoryEntityRepository categoryEntityRepository) {
        super(mapper, repository);
        this.categoryEntityRepository = categoryEntityRepository;
    }

    @Override
    public ProductEntity enrich(ProductEntity entity, Product product) {
        Long categoryId = Objects.requireNonNull(
                product.getType().getId(),
                "Category id cannot be null."
        );

        CategoryEntity category = categoryEntityRepository.findById(categoryId)
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

        CategoryEntity categoryEntity = categoryEntityRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + categoryId + " not found."));

        productEntity.setType(categoryEntity);
        return mapper.map(productEntity);
    }
}
