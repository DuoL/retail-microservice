package com.project.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Product")

public class Product {

    @ApiModelProperty(value = "The product Id", readOnly = true)
    private Long productId;

    @ApiModelProperty(value = "The store Id", readOnly = true)
    private Long storeId;

    @ApiModelProperty(value = "The product name")
    private String productName;

//    @ApiModelProperty(value = "The status of the product")
//    private ProductStatus status;

    @ApiModelProperty(value = "The description of the item")
    private String description;

    @ApiModelProperty(value = "an adhoc SKU")
    @Size(min = 5, max = 10, message = "allowing only alpha-numeric with a min length of 5 and max of 10")
    private String sku;

    @ApiModelProperty("The price of this product")
    private BigDecimal price;


}
