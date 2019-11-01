package com.project.retail.service;

import com.project.retail.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    /**
     * Add/Update a stock
     *
     * @param storeId
     * @param productId
     */
    public String addOrUpdateStock(Long storeId, Long productId) {
        return "add or update stock based on storeId "
                + storeId
                + " productId "
                + productId;
    }
}
