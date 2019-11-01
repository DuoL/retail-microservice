package com.project.retail.rest;

import com.project.retail.service.StoreService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "Retail store API", description = "API that contains store related endpoints")
@RestController("storeControllerV1")
@RequestMapping("/retail/v1/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @ApiOperation(value = "Create store")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of store"),
            @ApiResponse(code = 412, message = "Precondition failure"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createStore(@RequestParam(value = "storeName") String storeName) {
        log.debug("Creating store", storeName);
        return storeService.create(storeName);
    }

    @ApiOperation(value = "Get a list of stores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of store list"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(method = RequestMethod.GET)
    public String getStoreList() {
        log.debug("Get store List");
        return storeService.getStoreList();
    }

    @ApiOperation(value = "Get store by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public String getStoreById(@PathVariable(value = "storeId") long storeId) {
        log.debug("get store detail by Id: {} ", storeId);
        return storeService.getStoreById(storeId);
    }
}