package com.api.rest.web.assemblers;

import com.api.rest.model.bean.user.User;
import com.api.rest.web.resources.impl.UsersResource;
import lombok.NonNull;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler implements RepresentationModelAssembler<User, User> {

    @Override
    public @NonNull User toModel(User entity) {
        entity.add(linkTo(methodOn(UsersResource.class).getUserIdWithRoles(entity.getId())).withRel("roles"));
        entity.add(linkTo(methodOn(UsersResource.class).getUserId(entity.getId())).withSelfRel());
        return entity;
    }
}
