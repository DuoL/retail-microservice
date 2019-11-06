package com.project.retail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("RequestStock")
public class StockRequest {

    @ApiModelProperty(value = "stock id")
    private Long stockId;

    @NotNull
    @ApiModelProperty(value = "store id")
    private Long storeId;

    @NotNull
    @ApiModelProperty(value = "product id")
    private Long productId;

    @NotNull
    @ApiModelProperty(value = "count")
    private Long count;
}
