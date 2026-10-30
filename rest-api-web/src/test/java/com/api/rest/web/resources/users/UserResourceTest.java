package com.api.rest.web.resources.users;

import com.api.rest.config.security.TestSecurityConfiguration;
import com.api.rest.config.security.WithApplicationUser;
import com.api.rest.model.User;
import com.api.rest.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UsersApi.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles({"test", "noauth"})
@Import(TestSecurityConfiguration.class)
class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    @WithApplicationUser(roles = "ADMIN")
    void findAllPagedExpectResult() throws Exception {
        List<User> list = List.of(
                new User(1L, "Giacomo", "Chiavolotti", "c.giacomo@hotmail.it", "23G04c83."
                        ,"c.giacomo@hotmail.it", true, false, List.of("ADMIN")),
                new User(2L, "Viktor", "Nicola", "v.nicola@hotmail.it", "23G04c83."
                        ,"v.nicola@hotmail.it", true, false, List.of("ADMIN"))
        );

        Pageable pageable = PageRequest.of(0, 10);
        Page<User> result = new PageImpl<>(list, pageable, list.size());

        Mockito.when(userService.findAll(isA(Pageable.class))).thenReturn(result);

        mockMvc.perform(get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.pageable").exists())
                .andExpect(jsonPath("$.pageable.pageNumber").value(0))
                .andExpect(jsonPath("$.pageable.pageSize").value(10))
                .andExpect(jsonPath("$.first").value(true))
                .andExpect(jsonPath("$.last").value(true));
    }


    @Test
    @WithApplicationUser(roles = "ADMIN")
    void findByIdExpectResult() throws Exception {
        User user = new User(1L, "Giacomo", "Chiavolotti", "c.giacomo@hotmail.it", "23G04c83."
                ,"c.giacomo@hotmail.it", true, false, List.of("ADMIN"));

        Mockito.when(userService.findById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.id").value(1L),
                        jsonPath("$.name").value("Giacomo"),
                        jsonPath("$.surname").value("Chiavolotti"),
                        jsonPath("$.email").value("c.giacomo@hotmail.it"),
                        jsonPath("$.roles[0]").value("ADMIN")
                );
    }

}
