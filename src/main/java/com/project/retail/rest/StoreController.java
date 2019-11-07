package com.project.retail.rest;

import com.project.retail.dto.Store;
import com.project.retail.dto.request.StoreRequest;
import com.project.retail.service.StoreService;
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

import java.util.List;

@Slf4j
@Api(value = "Retail store API", description = "API that contains store related endpoints")
@RestController("storeControllerV1")
@RequestMapping(StoreController.COLLECTION_PATH)
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    public static final String COLLECTION_PATH = "/retail/v1/stores";

    @ApiOperation(value = "Create a store")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful creation of store"),
            @ApiResponse(code = 412, message = "Precondition failure"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Store createStore(@Validated @RequestBody StoreRequest storeRequest) {
        log.debug("Creating store", storeRequest.getStoreName());
        return storeService.create(storeRequest);
    }

    @ApiOperation(value = "Get a list of stores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of store list"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(method = RequestMethod.GET)
    public List<Store> getStoreList() {
        log.debug("Get store List");
        return storeService.getStoreList();
    }

    @ApiOperation(value = "Get store by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public Store getStoreById(@PathVariable(value = "storeId") long storeId) {
        log.debug("get store detail by Id: {} ", storeId);
        return storeService.getStoreById(storeId);
    }
}