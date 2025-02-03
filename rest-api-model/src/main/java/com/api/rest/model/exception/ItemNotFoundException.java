package com.api.rest.model.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException {

    private final List<String> errors;

    public ItemNotFoundException(List<String> errors) {
        this.errors = errors;
    }
}
