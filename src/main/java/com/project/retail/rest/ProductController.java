package com.project.retail.rest;

import com.project.retail.dto.Product;
import com.project.retail.dto.request.ProductRequest;
import com.project.retail.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(value = "Product Management API", description = "API that contains product management")
@RestController("productControllerV1")
@RequestMapping("/retail/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Create product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 409, message = "Precondition failure"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/{storeId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product createProduct(
            @PathVariable(value = "storeId") Long storeId, @RequestBody ProductRequest productRequest) {
        log.debug("Creating product {} ", productRequest);
        return productService.create(storeId, productRequest);
    }

    @ApiOperation(value = "Get a list of products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public List<Product> getProductListByStoreId(@PathVariable("storeId") Long storeId) {
        return productService.getProductListByStoreId(storeId);
    }

    @ApiOperation(value = "Get a product by productId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET)
    public Product getProductByStoreId(
            @RequestParam("productId") Long productId) {
        return productService.getProductById(productId);
    }
}
