package com.project.retail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("StoreRequest")

public class StoreRequest {

    @NotNull
    @ApiModelProperty(value = "The store name")
    private String storeName;

    @ApiModelProperty(value = "The store id")
    private Long storeId;

    @ApiModelProperty(value = "The products of a store")
    private List<ProductRequest> productList;
}
