package com.api.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
* Product
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-10T11:42:00.326253500+01:00[Europe/Rome]", comments = "Generator version: 7.16.0")
public class Product {

  @JsonProperty("id")  
  private Long id;

  @JsonProperty("name")
  @Size(min = 3, max = 40)
  private String name;

  @JsonProperty("description")
  @Size(min = 3, max = 40)
  private String description;

  @JsonProperty("price")  
  private Double price;

  @JsonProperty("type")
  private @Valid Category type;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.type, product.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price, type);
  }

  @Override
  public String toString() {
    return "class Product {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    name: " + toIndentedString(name) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    price: " + toIndentedString(price) + "\n" +
    "    type: " + toIndentedString(type) + "\n" +
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
