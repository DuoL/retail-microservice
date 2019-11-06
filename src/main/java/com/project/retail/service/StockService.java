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
        StockEntity existingStockEntity = getStockEntityByStoreIdAndProductId(storeId, productId);
        if (existingStockEntity != null) {
            return updateStock(existingStockEntity, stockRequest);
        }
        return addStock(storeId, productId, stockRequest);
    }


    private Stock addStock(Long storeId, Long productId, StockRequest stockRequest) {
        ProductEntity productEntity = productService.getProductEntityById(productId);
        StoreEntity storeEntity = storeService.getStoreEntityById(storeId);
        return stockConverter.toDto(
                repo.save(stockConverter.toEntity(stockRequest, productEntity, storeEntity))
        );
    }

    private Stock updateStock(StockEntity stockEntity, StockRequest stockRequest) {
        stockEntity.setCount(stockRequest.getCount());
        return stockConverter.toDto(
                repo.save(stockEntity)
        );
    }

    public StockEntity getStockEntityByStoreIdAndProductId(Long storeId, Long productId) {
        return repo.getStockEntityByStoreAndProduct(storeId, productId);
    }
}
