package com.api.rest.orm.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
* Expense
*/
@Getter
@Setter
@Entity
@Table(name = "expense")
public class ExpenseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator = "expense_generator"
  )
  @SequenceGenerator(
          name = "expense_generator",
          sequenceName = "expense_seq",
          allocationSize = 1
  )
  private Long id;

  @Size(min = 3, max = 40)
  private String description;

  private Double amount;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "expense_id", nullable = false, foreignKey = @ForeignKey(name = "fk_expense_entity"))
  private List<ProductEntity> product = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id",
              nullable = false,
              foreignKey = @ForeignKey(
                      name = "fk_expense_user",
                      foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE")
  )
  private @Valid UserEntity user;


  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExpenseEntity expense = (ExpenseEntity) o;
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
    return "class ExpenseEntity {\n" +
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
