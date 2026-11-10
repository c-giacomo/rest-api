package com.api.rest.service.user;

import com.api.rest.mapper.impl.UserMapper;
import com.api.rest.model.User;
import com.api.rest.orm.entities.UserEntity;
import com.api.rest.orm.repositories.UserEntityRepository;
import com.api.rest.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserEntityRepository userEntityRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        userService = new UserService(userMapper, userEntityRepository);
    }

    @Test
    void shouldReturnUser() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("Giacomo");

        given(userEntityRepository.findById(1L))
                .willReturn(Optional.of(user));

        User result = userService.findById(1L);

        assertThat(result.getName()).isEqualTo("Giacomo");
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        given(userEntityRepository.findById(1L))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> userService.findById(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Entity not found with id: 1");
    }
}
