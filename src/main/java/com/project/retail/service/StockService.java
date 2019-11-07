package com.project.retail.service;

import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StockEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Stock;
import com.project.retail.dto.request.StockRequest;
import com.project.retail.function.StockConverter;
import com.project.retail.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {
    private final StockRepository repo;
    private final ProductService productService;
    private final StoreService storeService;
    private final StockConverter stockConverter;

    /**
     * Add/Update a stock
     *
     * @param storeId
     * @param productId
     */
    public Stock addOrUpdateStock(Long storeId, Long productId, StockRequest stockRequest) {
        Long stockId = stockRequest.getStockId();
        if (stockId != null && repo.getOne(stockId) != null) {
            return updateStock(stockId, stockRequest);
        }
        return addStock(storeId, productId, stockRequest);
    }


    private Stock addStock(Long storeId, Long productId, StockRequest stockRequest) {
        StoreEntity storeEntity = storeService.getStoreEntityById(storeId);
        ProductEntity productEntity = productService.getProductEntityById(productId);
        StockEntity stockEntity = stockConverter.toEntity(stockRequest);
        stockEntity.setStore(storeEntity);
        stockEntity.setProduct(productEntity);
        return stockConverter.toDto(
                repo.save(stockEntity)
        );
    }

    private Stock updateStock(Long stockId, StockRequest stockRequest) {
        StockEntity stockEntity = repo.getOne(stockId);
        stockEntity.setCount(stockRequest.getCount());
        return stockConverter.toDto(
                repo.save(stockEntity)
        );
    }
}
