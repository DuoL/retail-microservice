package com.project.retail.service;

import com.project.retail.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public String create(Long storeId) {
        return "creating request for this store " + storeId;
    }
}
