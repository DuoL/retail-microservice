package com.project.retail.rest;

import com.project.retail.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "Retail request API", description = "API that contains request related endpoints")
@RestController("orderControllerV1")
@RequestMapping("/retail/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ApiOperation(value = "create an request")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of request"),
            @ApiResponse(code = 412, message = "Precondition failure"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/{storeId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(//@Validated @RequestBody OrderRequest orderRequest,
                         @PathVariable("storeId") Long storeId) {
        return orderService.create(storeId);
    }
}
