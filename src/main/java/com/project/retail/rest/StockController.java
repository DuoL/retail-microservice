package com.project.retail.rest;

import com.project.retail.dto.Stock;
import com.project.retail.dto.request.StockRequest;
import com.project.retail.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "Retail stock API", description = "API that contains stock related endpoints")
@RestController("stockControllerV1")
@RequestMapping(StockController.COLLECTION_PATH)
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    public static final String COLLECTION_PATH = "/retail/v1/stock";

    @ApiOperation(value = "Add/Update stock")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of store")})
    @RequestMapping(value = "/{storeId}/{productId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Stock addOrUpdateStock(
            @PathVariable("storeId") Long storeId,
            @PathVariable("productId") Long productId,
            @Validated @RequestBody StockRequest stockRequest) {
        return stockService.addOrUpdateStock(storeId, productId, stockRequest);
    }
}
