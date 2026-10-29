package com.api.rest.service.security;

import com.api.rest.orm.entities.user.UserEntity;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class ApplicationUser extends User {

    private final Long id;
    private final String email;
    private final String name;
    private final String surname;

    public ApplicationUser(UserEntity entity) {
        super(entity.getUsername(), entity.getPassword(), entity.isEnabled(), true, true, !entity.isLocked(),
                entity.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).toList());
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.surname = entity.getSurname();
    }
}
