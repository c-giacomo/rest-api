package com.api.rest.orm.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
* Product
*/
@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator = "product_generator"
  )
  @SequenceGenerator(
          name = "product_generator",
          sequenceName = "product_seq",
          allocationSize = 1
  )
  private Long id;

  @Size(min = 3, max = 40)
  private String name;

  @Size(min = 3, max = 40)
  private String description;

  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
          name = "category_id",
          nullable = false,
          foreignKey = @ForeignKey(name = "fk_product_category")
  )
  private CategoryEntity type;



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductEntity product = (ProductEntity) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.price, product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price, type);
  }

  @Override
  public String toString() {
    return "class ProductEntity {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    name: " + toIndentedString(name) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    price: " + toIndentedString(price) + "\n" +
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
