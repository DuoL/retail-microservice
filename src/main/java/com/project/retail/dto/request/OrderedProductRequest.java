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
@ApiModel("OrderedProductRequest")
public class OrderedProductRequest {
    @NotNull
    @ApiModelProperty(value = "product id")
    private Long productId;

    @NotNull
    @ApiModelProperty(value = "count")
    private Long count;
}
