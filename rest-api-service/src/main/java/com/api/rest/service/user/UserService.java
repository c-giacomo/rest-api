package com.api.rest.service.user;

import com.api.rest.mapper.user.UserMapper;
import com.api.rest.model.bean.user.User;
import com.api.rest.orm.entities.role.RoleEntity;
import com.api.rest.orm.entities.user.UserEntity;
import com.api.rest.orm.repositories.user.UserEntityRepository;
import com.api.rest.service.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserEntityRepository, UserMapper, UserEntity, User> {

    public UserService(UserMapper mapper, UserEntityRepository repository) {
        super(mapper, repository);
    }

    public Page<User> findUser(Pageable pageable) {
        Page<UserEntity> entity = repository.findAll(pageable);
        return getRoles(entity);
    }


    private Page<User> getRoles(Page<UserEntity> entity) {
        return entity.map(i -> {
            User u = mapper.map(i);
            u.getRoles().addAll(i.getRoles().stream().map(RoleEntity::getDescription).toList());
            return u;
        });
    }

}
