package com.project.retail.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("product")
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "sku")
    @Size(min = 5, max = 10, message = "allowing only alpha-numeric with a min length of 5 and max of 10")
    private String sku;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "product")
    private StockEntity stock;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProductEntity) {
            ProductEntity other = (ProductEntity) o;
            return Objects.equals(productId, other.getProductId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (productId != null) {
            return productId.hashCode();
        } else {
            return super.hashCode();
        }
    }
}
