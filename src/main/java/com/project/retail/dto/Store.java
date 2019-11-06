package com.project.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("store")

public class Store {
    @ApiModelProperty(value = "The store id", readOnly = true)
    private Long storeId;

    @ApiModelProperty(value = "The store name")
    private String storeName;

    @ApiModelProperty(value = "A list of products")
    private List<Product> productList;

}
