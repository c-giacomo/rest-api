package com.api.rest.mapper.user;

import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.bean.user.User;
import com.api.rest.orm.entities.role.RoleEntity;
import com.api.rest.orm.entities.user.UserEntity;
import org.hibernate.LazyInitializationException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", imports = RoleEntity.class)
public interface UserMapper extends BaseMapper<UserEntity, User> {

    @Override
    @Mapping(target = "roles", source = "roles", qualifiedByName = "roleToString")
    User map(UserEntity userEntity);

    @Override
    @Mapping(target = "roles", ignore = true)
    UserEntity mapReverse(User user);

    @Named("roleToString")
    default List<String> roleToString(List<RoleEntity> roles) {
        try {
            return roles.stream().map(RoleEntity::getDescription).toList();
        } catch (LazyInitializationException ex) {
            return Collections.emptyList();
        }
    }

}
