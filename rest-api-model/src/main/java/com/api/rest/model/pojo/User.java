package com.api.rest.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * User
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-14T21:52:20.312704100+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
public class User {

  @JsonProperty("id")
  private Long id;

  @NotNull @Size(min = 3, max = 20) 
  @JsonProperty("name")
  private String name;

  @NotNull @Size(min = 3, max = 20) 
  @JsonProperty("surname")
  private String surname;

  @NotNull @Size(min = 3, max = 30) 
  @JsonProperty("username")
  private String username;

  @Size(min = 3, max = 30) 
  @JsonProperty("email")
  private String email;

  @Valid 
  @JsonProperty("roles")
  private List<@Valid Role> roles = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.surname, user.surname) &&
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, username, email, roles);
  }

  @Override
  public String toString() {
    return "class User {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    name: " + toIndentedString(name) + "\n" +
    "    surname: " + toIndentedString(surname) + "\n" +
    "    username: " + toIndentedString(username) + "\n" +
    "    email: " + toIndentedString(email) + "\n" +
    "    roles: " + roles.stream().map(Role::getDescription).collect(Collectors.joining(";")) + "\n" +
    "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

