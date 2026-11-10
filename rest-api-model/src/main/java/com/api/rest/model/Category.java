package com.api.rest.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

/**
* Category
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-10T11:42:00.326253500+01:00[Europe/Rome]", comments = "Generator version: 7.16.0")
public class Category {

  @JsonProperty("id")  
  private Long id;

  @JsonProperty("name")
  @Size(min = 3, max = 40)
  private String name;

  @JsonProperty("description")
  @Size(min = 3, max = 40)
  private String description;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.id, category.id) &&
        Objects.equals(this.name, category.name) &&
        Objects.equals(this.description, category.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    return "class Category {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    name: " + toIndentedString(name) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
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
