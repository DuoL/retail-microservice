package com.project.retail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("ProductRequest")
public class ProductRequest {
    @NotNull
    @ApiModelProperty(value = "store id")
    private Long storeId;

    @NotNull
    @ApiModelProperty(value = "product name")
    private String productName;

    @ApiModelProperty(value = "description of the item")
    private String description;

    @NotNull
    @ApiModelProperty(value = "an adhoc SKU")
    @Size(min = 5, max = 10, message = "allowing only alpha-numeric with a min length of 5 and max of 10")
    private String sku;

    @NotNull
    @ApiModelProperty("The price of this product")
    private BigDecimal price;
}
