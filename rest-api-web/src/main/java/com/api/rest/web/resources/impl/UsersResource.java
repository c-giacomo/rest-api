package com.api.rest.web.resources.impl;

import com.api.rest.model.pojo.User;
import com.api.rest.web.resources.UsersApi;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersResource implements UsersApi {
    @Override
    public ResponseEntity<List<User>> getUsers(Pageable pageable) {
        return null;
    }
}
