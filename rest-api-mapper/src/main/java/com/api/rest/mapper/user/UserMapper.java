package com.api.rest.mapper.user;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, User> {

}
