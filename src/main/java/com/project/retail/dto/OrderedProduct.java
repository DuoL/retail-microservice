package com.project.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Product")
public class OrderedProduct {
    @ApiModelProperty(value = "The product Id", readOnly = true)
    private Long productId;

    @ApiModelProperty(value = "The product name")
    private String productName;

    @ApiModelProperty("count")
    private Long count;
}
