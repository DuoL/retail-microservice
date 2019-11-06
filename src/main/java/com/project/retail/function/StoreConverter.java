package com.project.retail.function;

import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Product;
import com.project.retail.dto.Store;
import com.project.retail.dto.request.StoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class StoreConverter {

    private final OrderConverter orderConverter;
    private final ProductConverter productConverter;

    public Store toDto(StoreEntity storeEntity) {
        Store result = new Store();
        result.setStoreId(storeEntity.getStoreId());
        result.setStoreName(storeEntity.getStoreName());
        result.setProductList(getProducts(storeEntity));
        return result;
    }

    public StoreEntity toEntity(StoreRequest storeRequest) {
        StoreEntity result = new StoreEntity();
        result.setStoreName(storeRequest.getStoreName());
        result.setProducts(getProducts(storeRequest, result));
        return result;
    }

    private Set<ProductEntity> getProducts(
            StoreRequest request,
            StoreEntity storeEntity) {
        boolean hasProduct = request.getProductList() != null;
        Set<ProductEntity> existingProducts = new HashSet<>();
        if (hasProduct) {
            request.getProductList().forEach(x -> {
                existingProducts.add(
                        productConverter.toEntity(x, storeEntity, null)
                );
            });
        }
        return existingProducts;

        /** Update logic if needed **/
//        Set<ProductEntity> existingProducts = storeEntity.getProducts() != null ? storeEntity.getProducts() : new HashSet<>();
//                if (x.getProductId() != null) {
//                    existingProducts
//                            .stream()
//                            .filter(y -> x.getProductId().equals(y.getProductId()))
//                            .findFirst()
//                            .ifPresent(y -> {
//                                y.setDescription(x.getDescription());
//                                y.setProductName(x.getProductName());
//                                y.setPrice(x.getPrice());
//                                y.setSku(x.getSku());
//                            });
//                } else {
//
//                }
    }

    private List<Product> getProducts(StoreEntity entity) {
        List<Product> result = new ArrayList<>();
        entity.getProducts().forEach(x -> {
            result.add(productConverter.toDto(x));
        });
        return result;
    }


    /** Update logic if needed **/
//    Set<OrderEntity> existingOrders = entity.getOrders() != null ? entity.getOrders() : new HashSet<>();
//    if(x.getOrderId() != null) {
//        System.out.println("runs to if " + x.toString());
//        existingOrders
//                .stream()
//                .filter(y -> x.getOrderId().equals(y.getOrderId()))
//                .findFirst()
//                .ifPresent(y -> {
//                    orderConverter.toEntity(x, entity);
//                });
//
//    } else {
}
