package com.api.rest.orm.entities;


import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

  @OneToMany(
          mappedBy = "expense",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private Set<ExpenseProductEntity> expenseProducts = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
          name = "user_id",
          nullable = false,
          foreignKey = @ForeignKey(name = "fk_expense_user")
  )
  @OnDelete(action = OnDeleteAction.CASCADE)
  private UserEntity user;


  
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
        Objects.equals(this.expenseProducts, expense.expenseProducts) &&
        Objects.equals(this.user, expense.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, amount, date, expenseProducts, user);
  }

  @Override
  public String toString() {
    return "class ExpenseEntity {\n" +
    "    id: " + toIndentedString(id) + "\n" +
    "    description: " + toIndentedString(description) + "\n" +
    "    amount: " + toIndentedString(amount) + "\n" +
    "    date: " + toIndentedString(date) + "\n" +
    "    expenseProducts: " + toIndentedString(expenseProducts) + "\n" +
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
