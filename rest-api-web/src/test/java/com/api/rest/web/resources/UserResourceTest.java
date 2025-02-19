package com.api.rest.web.resources;

import com.api.rest.model.bean.user.User;
import com.api.rest.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UsersApi.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UserService userService;

    @Test
    void test1() throws Exception {
        List<User> list = List.of(
                new User(1L, "Giacomo", "Chiavolotti", "c.giacomo@hotmail.it", "c.giacomo@hotmail.it", List.of("ADMIN")),
                new User(2L, "Viktor", "Nicola", "v.nicola@hotmail.it", "v.nicola@hotmail.it", List.of("ADMIN"))
        );

        Mockito.when(userService.findAll()).thenReturn(list);

        Page<User> result = new PageImpl<>(list);

        mockMvc.perform(get("/api/v1/users"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(result))
                );
    }

}
