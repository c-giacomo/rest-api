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
 * Role
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-14T21:52:20.312704100+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
public class Role {

  @JsonProperty("id")
  private Long id;

  @NotNull @Size(min = 3, max = 20) 
  @JsonProperty("description")
  private String description;

  @Valid 
  @JsonProperty("users")
  private List<@Valid User> users = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role roles = (Role) o;
    return Objects.equals(this.id, roles.id) &&
        Objects.equals(this.description, roles.description);
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
    "    user: " + users.stream().map(User::getName).collect(Collectors.joining(";")) + "\n" +
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

