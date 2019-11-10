package com.project.retail.service;

import com.project.retail.domain.OrderEntity;
import com.project.retail.domain.OrderedProductEntity;
import com.project.retail.domain.ProductEntity;
import com.project.retail.dto.Order;
import com.project.retail.dto.request.OrderRequest;
import com.project.retail.function.OrderConverter;
import com.project.retail.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repo;
    private final OrderConverter orderConverter;
    private final StoreService storeService;
    private final ProductService productService;

    /**
     * Creates an order
     *
     * @param storeId to  create an order
     * @return order created
     */
    public Order create(OrderRequest orderRequest, Long storeId) {
        OrderEntity orderEntity = orderConverter.toEntity(orderRequest);
        setStoreEntity(orderEntity, storeId);
        setOrderedProductList(orderRequest, orderEntity);
        return orderConverter.toDto(repo.save(orderEntity));
    }

    /**
     * Get an order by orderId
     *
     * @return order
     */
    public Order getOrderById(Long orderId) {
        return orderConverter.toDto(getOrderEntityById(orderId));
    }

    public OrderEntity getOrderEntityById(Long orderId) {
        if (orderId == null) return null;
        return repo.getOne(orderId);
    }

    private void setStoreEntity(OrderEntity orderEntity, Long storeId) {
        orderEntity.setStore(storeService.getStoreEntityById(storeId));
    }

    private void setOrderedProductList(OrderRequest orderRequest, OrderEntity orderEntity) {
        Set<OrderedProductEntity> orderedProductEntitySet = new HashSet<>();
        if (orderRequest.getOrderedProductRequestList() != null) {
            orderRequest.getOrderedProductRequestList()
                    .forEach(x -> {
                        ProductEntity productEntity = productService.getProductEntityById(x.getProductId());
                        if (productEntity != null) {
                            OrderedProductEntity orderedProductEntity = OrderedProductEntity
                                    .builder()
                                    .productEntity(productEntity)
                                    .order(orderEntity)
                                    .count(x.getCount())
                                    .build();
                            orderedProductEntitySet.add(orderedProductEntity);
                        } else {
                            return;
                        }
                    });
        }
        orderEntity.setOrderedProductEntitySet(orderedProductEntitySet);
    }
}
