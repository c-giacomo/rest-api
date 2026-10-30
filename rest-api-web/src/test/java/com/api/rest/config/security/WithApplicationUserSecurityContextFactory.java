package com.api.rest.config.security;

import com.api.rest.orm.entities.user.UserEntity;
import com.api.rest.service.security.ApplicationUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Set;

public class WithApplicationUserSecurityContextFactory implements WithSecurityContextFactory<WithApplicationUser> {

    @Override
    public SecurityContext createSecurityContext(WithApplicationUser annotation) {
        UserEntity entity = new UserEntity();
        entity.setId(annotation.id());
        entity.setUsername(annotation.username());
        entity.setPassword("n/a");
        entity.setName(annotation.name());
        entity.setSurname(annotation.surname());
        entity.setEmail(annotation.email());
        entity.setEnabled(true);
        entity.setLocked(false);
        entity.setRoles(Set.of(annotation.roles()));

        ApplicationUser user = new ApplicationUser(entity);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
        return context;
    }
}
