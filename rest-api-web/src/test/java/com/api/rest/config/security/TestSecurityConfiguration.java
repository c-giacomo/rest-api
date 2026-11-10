package com.api.rest.config.security;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@TestConfiguration(proxyBeanMethods = false)
@EnableWebSecurity
public class TestSecurityConfiguration { }
