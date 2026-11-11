package com.api.rest.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ExpenseProduct
 */

@Getter
@Setter
@Entity
@Table(name = "expense_product")
public class ExpenseProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "expense_product_generator")
    @SequenceGenerator(
            name = "expense_product_generator",
            sequenceName = "expense_product_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "fk_expense_product_expense")
    )
    private ExpenseEntity expense;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "fk_expense_product_product")
    )
    private ProductEntity product;

    @Column(nullable = false)
    private Integer quantity;
}
