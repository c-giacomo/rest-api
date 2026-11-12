package com.api.rest.web.resources.expense.impl;

import com.api.rest.model.Expense;
import com.api.rest.service.ExpenseService;
import com.api.rest.service.security.ApplicationUser;
import com.api.rest.web.resources.expense.ExpenseApi;
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
public class ExpenseResource implements ExpenseApi {

    private final ExpenseService expenseService;

    @Override
    public ResponseEntity<Expense> createExpense(Expense expense, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(expenseService.create(expense, applicationUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteExpense(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        expenseService.delete(id, applicationUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Expense> getExpenseById(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(expenseService.findById(id, applicationUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Expense>> getExpenses(Pageable pageable, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(expenseService.findAll(pageable, applicationUser), HttpStatus.OK);
    }

}
