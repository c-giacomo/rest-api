package com.api.rest.mapper.user;

import com.api.rest.orm.entities.user.UserEntity;
import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.bean.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, User> {
    @Override
    @Mapping(target = "roles", ignore = true)
    User map(UserEntity userEntity);

    @Override
    @Mapping(target = "roles", ignore = true)
    UserEntity mapReverse(User user);
}
