package com.project.retail.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("OrderRequest")
public class OrderRequest {

    @ApiModelProperty(value = "The order Id", readOnly = true)
    private Long orderId;

    @NotNull
    @ApiModelProperty(value = "The store Id", readOnly = true)
    private Long storeId;

    @ApiModelProperty(value = "date/time of the request")
    private Instant orderDate;

    @NotNull
    @ApiModelProperty(value = "one or more products purchased")
    private List<ProductRequest> productList;

    @NotNull
    @ApiModelProperty(value = "first name")
    private String firstName;

    @NotNull
    @ApiModelProperty(value = "last name")
    private String lastName;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "phone")
    private String phone;
}
