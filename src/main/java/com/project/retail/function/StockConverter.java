package com.project.retail.function;

import com.project.retail.domain.StockEntity;
import com.project.retail.dto.Stock;
import com.project.retail.dto.request.StockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockConverter {
    public StockEntity toEntity(StockRequest stockRequest) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setCount(stockRequest.getCount());
        return stockEntity;
    }

    public Stock toDto(StockEntity stockEntity) {
        Stock stock = new Stock();
        stock.setStockId(stockEntity.getStockId());
        stock.setProductId(stockEntity.getProduct().getProductId());
        stock.setCount(stockEntity.getCount());
        return stock;
    }

}
