package com.api.rest.config.security;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@WithSecurityContext(factory = WithApplicationUserSecurityContextFactory.class)
public @interface WithApplicationUser {

    long id() default 1L;
    String username() default "test";
    String name() default "Test";
    String surname() default "User";
    String email() default "test@example.com";
    String[] roles() default {"USER"};
}
