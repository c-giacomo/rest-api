package com.api.rest.web.resources.impl;

import com.api.rest.model.User;
import com.api.rest.service.security.ApplicationUser;
import com.api.rest.service.user.UserService;
import com.api.rest.web.resources.UsersApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UsersResource implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> getUserId(Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<User>> getUsers(Pageable pageable, @AuthenticationPrincipal ApplicationUser applicationUser) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
