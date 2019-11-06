package com.project.retail.function;

import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StockEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Stock;
import com.project.retail.dto.request.StockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockConverter {
    public StockEntity toEntity(
            StockRequest stockRequest,
            ProductEntity productEntity,
            StoreEntity storeEntity) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setProduct(productEntity);
        stockEntity.setStore(storeEntity);
        stockEntity.setCount(stockRequest.getCount());
        return stockEntity;
    }

    public Stock toDto(StockEntity stockEntity) {
        Stock stock = new Stock();
        stock.setStockId(stockEntity.getStockId());
        stock.setStoreId(stockEntity.getStore().getStoreId());
        stock.setProductId(stockEntity.getProduct().getProductId());
        stock.setCount(stockEntity.getCount());
        return stock;
    }

}
