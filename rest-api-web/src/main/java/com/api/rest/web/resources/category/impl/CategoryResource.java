package com.api.rest.web.resources.category.impl;

import com.api.rest.model.Category;
import com.api.rest.service.CategoryService;
import com.api.rest.service.security.ApplicationUser;
import com.api.rest.web.resources.category.CategoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryResource implements CategoryApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<Category> createCategory(Category category, @AuthenticationPrincipal ApplicationUser applicationUser) {
        Category result = categoryService.create(category);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Category>> getCategory(Pageable pageable, @AuthenticationPrincipal ApplicationUser applicationUser) {
        Page<Category> result = categoryService.findAll(pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> getCategoryId(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        Category result = categoryService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long id, Category category, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }
}
