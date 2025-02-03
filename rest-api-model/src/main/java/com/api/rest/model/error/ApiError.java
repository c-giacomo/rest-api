package com.api.rest.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ApiError
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-02T18:13:56.636291700+01:00[Europe/Rome]", comments = "Generator version: 7.10.0")
public class ApiError {

  @JsonProperty("status")
  private HttpStatus status;

  @JsonProperty("errors")
  private List<String> errors = new ArrayList<>();

  @JsonProperty("message")
  private String message;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.errors, apiError.errors) &&
         Objects.equals(this.message, apiError.message) &&
         Objects.equals(this.status, apiError.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, message);
  }

  @Override
  public String toString() {
    return "class ApiError {\n" +
    "    errors: " + toIndentedString(errors) + "\n" +
    "    message: " + toIndentedString(message) + "\n" +
    "    status: " + toIndentedString(status.toString()) + "\n" +
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

