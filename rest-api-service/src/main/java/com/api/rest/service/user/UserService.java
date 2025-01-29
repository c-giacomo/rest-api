package com.api.rest.service.user;

import com.api.rest.data.entities.user.UserEntity;
import com.api.rest.data.repositories.user.UserEntityRepository;
import com.api.rest.mapper.user.UserMapper;
import com.api.rest.model.user.User;
import com.api.rest.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserEntityRepository, UserMapper, UserEntity, User> {

}
