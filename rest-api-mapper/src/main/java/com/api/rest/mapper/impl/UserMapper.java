package com.api.rest.mapper.impl;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, User> {

}
