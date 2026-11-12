package com.api.rest.service;

import com.api.rest.mapper.impl.ExpenseMapper;
import com.api.rest.model.Expense;
import com.api.rest.model.Product;
import com.api.rest.orm.entities.ExpenseEntity;
import com.api.rest.orm.entities.ExpenseProductEntity;
import com.api.rest.orm.entities.ProductEntity;
import com.api.rest.orm.repositories.ExpenseRepository;
import com.api.rest.orm.repositories.ProductRepository;
import com.api.rest.orm.repositories.UserRepository;
import com.api.rest.service.security.ApplicationUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ExpenseService extends AbstractService<Long, ExpenseRepository, ExpenseMapper, ExpenseEntity, Expense> {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseMapper mapper, ExpenseRepository repository, ProductRepository productRepository, UserRepository userRepository) {
        super(mapper, repository);
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ExpenseEntity enrich(ExpenseEntity entity, Expense dto, Object principal) {
        Map<Long, Long> productMap = dto.getProduct().stream()
                .collect(Collectors.groupingBy(
                        Product::getId,
                        Collectors.counting()
                ));

        ApplicationUser user = (ApplicationUser) principal;
        Set<ExpenseProductEntity> expenseProductEntities = new HashSet<>();

        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        productMap.forEach((productId, productCount) -> {
            ExpenseProductEntity expenseProductEntity = new ExpenseProductEntity();
            expenseProductEntity.setExpense(entity);

            ProductEntity productEntity = productRepository.findById(productId).orElse(null);
            expenseProductEntity.setProduct(productEntity);

            assert productEntity != null;
            sum.set(sum.get() + (productEntity.getPrice() * productCount));

            expenseProductEntity.setQuantity(productCount.intValue());
            expenseProductEntities.add(expenseProductEntity);
        });

        entity.setAmount(sum.get());
        entity.setExpenseProducts(expenseProductEntities);
        entity.setUser(userRepository.findById(user.getId()).orElse(null));
        return entity;
    }
}
