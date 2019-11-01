package com.project.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Order")

public class Order {
    @ApiModelProperty(value = "The request Id", readOnly = true)
    private long orderId;

    @ApiModelProperty(value = "The store Id", readOnly = true)
    private long storeId;

    @ApiModelProperty(value = "date/time of the request")
    private Instant orderDate;

    @ApiModelProperty(value = "one or more products purchased")
    private List<Product> productList;

    @ApiModelProperty(value = "first name")
    private String firstName;

    @ApiModelProperty(value = "last name")
    private String lastName;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "phone")
    private String phone;
}
