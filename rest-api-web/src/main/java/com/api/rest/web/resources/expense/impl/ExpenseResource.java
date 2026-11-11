package com.api.rest.web.resources.expense.impl;

import com.api.rest.model.Expense;
import com.api.rest.orm.repositories.ExpenseRepository;
import com.api.rest.service.ExpenseService;
import com.api.rest.service.security.ApplicationUser;
import com.api.rest.web.resources.expense.ExpenseApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExpenseResource implements ExpenseApi {

    private final ExpenseService expenseService;

    @Override
    public ResponseEntity<Expense> createExpense(Expense expense, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Expense>> getExpense(Pageable pageable, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return null;
    }

    @Override
    public ResponseEntity<Expense> getExpenseId(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return null;
    }
}
