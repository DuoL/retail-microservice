package com.project.retail.function;

import com.project.retail.domain.OrderEntity;
import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Order;
import com.project.retail.dto.Product;
import com.project.retail.dto.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component

public class OrderConverter {
    private final ProductConverter productConverter;

    public OrderEntity toEntity(
            OrderRequest orderRequest,
            StoreEntity storeEntity) {
        OrderEntity result = new OrderEntity();
        result.setPhone(orderRequest.getPhone());
        result.setOrderDate(orderRequest.getOrderDate());
        result.setLastName(orderRequest.getLastName());
        result.setFirstName(orderRequest.getFirstName());
        result.setEmail(orderRequest.getEmail());
        result.setProductList(getProducts(orderRequest, storeEntity, result));
        return result;
    }


    public Order toDto(
            OrderEntity orderEntity) {
        Order result = new Order();
        result.setEmail(orderEntity.getEmail());
        result.setFirstName(orderEntity.getFirstName());
        result.setLastName(orderEntity.getLastName());
        result.setOrderDate(orderEntity.getOrderDate());
        result.setOrderId(orderEntity.getOrderId());
        result.setPhone(orderEntity.getPhone());
        result.setStoreId(orderEntity.getStore().getStoreId());
        result.setProductList(getProducts(orderEntity));
        return result;
    }


    private Set<ProductEntity> getProducts(
            OrderRequest request,
            StoreEntity storeEntity,
            OrderEntity orderEntity) {
        boolean hasProduct = request.getProductList() != null;
        Set<ProductEntity> existingProducts = new HashSet<>();
        System.out.println(request.toString());
        if (hasProduct) {
            request.getProductList().forEach(x -> {
                existingProducts.add(
                        productConverter.toEntity(x, storeEntity, orderEntity)
                );
            });
        }
        return existingProducts;
    }

    private List<Product> getProducts(OrderEntity entity) {
        List<Product> result = new ArrayList<>();

        entity.getProductList().forEach(x -> {
            result.add(productConverter.toDto(x));
        });
        return result;
    }
}
