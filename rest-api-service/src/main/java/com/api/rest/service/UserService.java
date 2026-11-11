package com.api.rest.service;

import com.api.rest.mapper.impl.UserMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.UserEntity;
import com.api.rest.orm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserRepository, UserMapper, UserEntity, User> {

    public UserService(UserMapper mapper, UserRepository repository) {
        super(mapper, repository);
    }
}
