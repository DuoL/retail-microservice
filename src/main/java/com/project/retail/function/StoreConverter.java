package com.project.retail.function;

import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Order;
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
        result.setOrderList(getOrders(storeEntity));
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
                        productConverter.toEntity(x, storeEntity)
                );
            });
        }
        return existingProducts;
    }

    private List<Product> getProducts(StoreEntity entity) {
        List<Product> result = new ArrayList<>();
        entity.getProducts().forEach(x -> {
            result.add(productConverter.toDto(x));
        });
        return result;
    }

    private List<Order> getOrders(StoreEntity storeEntity) {
        List<Order> result = new ArrayList<>();
        if (storeEntity.getOrders() != null) {
            storeEntity.getOrders().forEach(x -> {
                result.add(orderConverter.toDto(x));
            });
        }
        return result;
    }
}
