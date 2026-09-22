package com.api.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.*;


import jakarta.annotation.Generated;

/**
* Role
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-22T11:20:58.177494300+02:00[Europe/Rome]", comments = "Generator version: 7.16.0")
public class Role {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("description")
  @NotNull @Size(min = 3, max = 20) 
  private String description;

  @JsonProperty("users")
  private List<String> users = new ArrayList<>();
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(this.id, role.id) &&
        Objects.equals(this.description, role.description) &&
        Objects.equals(this.users, role.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, users);
  }

  @Override
  public String toString() {
    return "class Role {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    users: " + toIndentedString(users) + "\n" +
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
