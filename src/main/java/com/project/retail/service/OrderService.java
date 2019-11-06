package com.project.retail.service;

import com.project.retail.domain.OrderEntity;
import com.project.retail.dto.Order;
import com.project.retail.dto.request.OrderRequest;
import com.project.retail.function.OrderConverter;
import com.project.retail.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repo;
    private final OrderConverter orderConverter;
    private final StoreService storeService;

    public Order create(OrderRequest orderRequest, Long storeId) {
        OrderEntity orderEntity = orderConverter.toEntity(orderRequest, storeService.getStoreEntityById(storeId));
        setStoreEntity(orderEntity, storeId);
        return orderConverter.toDto(repo.save(orderEntity));
    }

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

}
