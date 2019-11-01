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
@ApiModel("Stock")

public class Stock {
    @ApiModelProperty(value = "The product Id", readOnly = true)
    private Long productId;

    @ApiModelProperty(value = "The store Id", readOnly = true)
    private Long storeId;

    @ApiModelProperty(value = "the total count in stock")
    private Long count;
}
