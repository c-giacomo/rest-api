package com.api.rest.mapper.role;

import com.api.rest.orm.entities.role.RoleEntity;
import com.api.rest.mapper.BaseMapper;
import com.api.rest.model.bean.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleEntity, Role> {

    @Override
    @Mapping(target = "users", ignore = true)
    Role map(RoleEntity roleEntity);

    @Override
    @Mapping(target = "users", ignore = true)
    RoleEntity mapReverse(Role role);
}
