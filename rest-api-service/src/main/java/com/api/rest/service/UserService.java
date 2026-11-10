package com.api.rest.service;

import com.api.rest.mapper.impl.UserMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.UserEntity;
import com.api.rest.orm.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserEntityRepository, UserMapper, UserEntity, User> {

    public UserService(UserMapper mapper, UserEntityRepository repository) {
        super(mapper, repository);
    }

}
