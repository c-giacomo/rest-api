package com.api.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
* User
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-27T13:35:04.133258900+01:00[Europe/Rome]", comments = "Generator version: 7.16.0")
public class User {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  @NotNull @Size(min = 3, max = 20) 
  private String name;

  @JsonProperty("surname")
  @NotNull @Size(min = 3, max = 20) 
  private String surname;

  @JsonProperty("username")
  @NotNull @Size(min = 3, max = 30) 
  private String username;

  @JsonProperty("password")
  @NotNull @Size(min = 6, max = 30)
  private String password;

  @JsonProperty("email")
  @Size(min = 3, max = 30) @Email
  private String email;

  @JsonProperty("enabled")
  private Boolean enabled;

  @JsonProperty("locked")
  private Boolean locked;

  @JsonProperty("roles")
  private List<String> roles = new ArrayList<>();
  
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
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.enabled, user.enabled) &&
        Objects.equals(this.locked, user.locked) &&
        Objects.equals(this.roles, user.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, username, password, email, enabled, locked, roles);
  }

  @Override
  public String toString() {
    return "class User {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    name: " + toIndentedString(name) + "\n" +
    "    surname: " + toIndentedString(surname) + "\n" +
    "    username: " + toIndentedString(username) + "\n" +
    "    password: " + toIndentedString(password) + "\n" +
    "    email: " + toIndentedString(email) + "\n" +
    "    enabled: " + toIndentedString(enabled) + "\n" +
    "    locked: " + toIndentedString(locked) + "\n" +
    "    roles: " + toIndentedString(roles) + "\n" +
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
