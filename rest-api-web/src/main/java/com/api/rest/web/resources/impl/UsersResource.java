package com.api.rest.web.resources.impl;

import com.api.rest.model.bean.user.User;
import com.api.rest.service.user.UserService;
import com.api.rest.web.resources.UsersApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersResource implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> getUserId(Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserIdWithRoles(Long id) {
        return new ResponseEntity<>(userService.findByIdWithRoles(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        return null;
    }
}
