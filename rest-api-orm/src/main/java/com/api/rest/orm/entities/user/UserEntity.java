package com.api.rest.orm.entities.user;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "users_generator"
    )
    @SequenceGenerator(
            name = "users_generator",
            sequenceName = "users_seq",
            allocationSize = 1
    )
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String surname;

    @NotNull
    @Size(min = 6, max = 30)
    private String password;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Email
    @Size(min = 3, max = 30)
    @Column(length = 30)
    private String email;

    private boolean enabled = true;
    private boolean locked = false;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, username, email);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles.stream().peek(System.out::print).collect(Collectors.joining(";")) +
                '}';
    }
}
