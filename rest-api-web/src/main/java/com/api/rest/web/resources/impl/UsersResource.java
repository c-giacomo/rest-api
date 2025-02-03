package com.api.rest.web.resources.impl;

import com.api.rest.model.user.User;
import com.api.rest.service.user.UserService;
import com.api.rest.web.resources.UsersApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersResource implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> getUserId(Integer id) { return null; }

    @Override
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        return null;
    }
}
