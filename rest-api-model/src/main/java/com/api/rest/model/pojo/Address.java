package com.api.rest.model.pojo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import jakarta.annotation.Generated;

/**
 * Address
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-12T16:43:43.828692500+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
public class Address {

  @JsonProperty("id")
  private Long id;

  @Size(min = 3, max = 20) 
  @JsonProperty("description")
  private String description;

  @Valid 
  @JsonProperty("user")
  private User user;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.id, address.id) &&
        Objects.equals(this.description, address.description) &&
        Objects.equals(this.user, address.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, user);
  }

  @Override
  public String toString() {
    return "class Address {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    user: " + toIndentedString(user) + "\n" +
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

