package com.project.retail.repository;

import com.project.retail.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
    StockEntity getStockEntityByStoreAndProduct(Long storeId, Long productId);
}
