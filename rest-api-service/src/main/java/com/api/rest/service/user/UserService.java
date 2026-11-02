package com.api.rest.service.user;

import com.api.rest.mapper.user.UserMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.user.UserEntity;
import com.api.rest.orm.repositories.user.UserEntityRepository;
import com.api.rest.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserEntityRepository, UserMapper, UserEntity, User> {

    public UserService(UserMapper mapper, UserEntityRepository repository) {
        super(mapper, repository);
    }

}
