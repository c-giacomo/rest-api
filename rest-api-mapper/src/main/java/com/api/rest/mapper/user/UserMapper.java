package com.api.rest.mapper.user;

import com.api.rest.data.UserEntity;
import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.pojo.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, User> {
}
