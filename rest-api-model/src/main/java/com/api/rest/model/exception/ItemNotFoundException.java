package com.api.rest.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {}

    public ItemNotFoundException(String errors) {
        super(errors);
    }
}
