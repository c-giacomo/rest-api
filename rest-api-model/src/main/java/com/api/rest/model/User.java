package com.api.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.*;


import jakarta.annotation.Generated;

/**
* User
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-22T11:20:58.177494300+02:00[Europe/Rome]", comments = "Generator version: 7.16.0")
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

  @JsonProperty("email")@Size(min = 3, max = 30) @jakarta.validation.constraints.Email 
  private String email;

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
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.roles, user.roles);
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
