package com.api.rest.model;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
* Expense
*/
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-10T11:42:00.326253500+01:00[Europe/Rome]", comments = "Generator version: 7.16.0")
public class Expense {

  @JsonProperty("id")  
  private Long id;

  @JsonProperty("description")  @Size(min = 3, max = 40) 
  private String description;

  @JsonProperty("amount")  
  private Double amount;

  @JsonProperty("date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Valid OffsetDateTime date;

  @JsonProperty("product")
  private List<@Valid Product> product = new ArrayList<>();

  @JsonProperty("user")
  private @Valid User user;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Expense expense = (Expense) o;
    return Objects.equals(this.id, expense.id) &&
        Objects.equals(this.description, expense.description) &&
        Objects.equals(this.amount, expense.amount) &&
        Objects.equals(this.date, expense.date) &&
        Objects.equals(this.product, expense.product) &&
        Objects.equals(this.user, expense.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, amount, date, product, user);
  }

  @Override
  public String toString() {
    return "class Expense {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    amount: " + toIndentedString(amount) + "\n" +
    "    date: " + toIndentedString(date) + "\n" +
    "    product: " + toIndentedString(product) + "\n" +
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
