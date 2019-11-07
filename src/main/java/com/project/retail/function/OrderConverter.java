package com.project.retail.function;

import com.project.retail.domain.OrderEntity;
import com.project.retail.dto.Order;
import com.project.retail.dto.OrderedProduct;
import com.project.retail.dto.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component

public class OrderConverter {
    public OrderEntity toEntity(
            OrderRequest orderRequest) {
        OrderEntity result = new OrderEntity();
        result.setPhone(orderRequest.getPhone());
        result.setOrderDate(orderRequest.getOrderDate());
        result.setLastName(orderRequest.getLastName());
        result.setFirstName(orderRequest.getFirstName());
        result.setEmail(orderRequest.getEmail());
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
        result.setOrderedProductList(getOrderedProduct(orderEntity));
        return result;
    }

    private List<OrderedProduct> getOrderedProduct(OrderEntity orderEntity) {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        orderEntity.getOrderedProductEntitySet()
                .forEach(x -> {
                    OrderedProduct orderedProduct = OrderedProduct.builder()
                            .count(x.getCount())
                            .productId(x.getProductEntity().getProductId())
                            .productName(x.getProductEntity().getProductName())
                            .build();
                    orderedProductList.add(orderedProduct);
                });
        return orderedProductList;
    }
}
