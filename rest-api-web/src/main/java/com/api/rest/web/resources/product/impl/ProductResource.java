package com.api.rest.web.resources.product.impl;

import com.api.rest.model.Product;
import com.api.rest.service.ProductService;
import com.api.rest.service.security.ApplicationUser;
import com.api.rest.web.resources.product.ProductApi;
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
public class ProductResource implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<Product> createProduct(Product product, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Product>> getProduct(Pageable pageable, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getProductId(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product product, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(productService.update(id, product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProductCategory(Long productId, Long categoryId, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(productService.switchCategory(productId, categoryId), HttpStatus.OK);
    }
}
