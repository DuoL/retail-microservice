package com.project.retail.repository;

import com.project.retail.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    List<ProductEntity> getProductEntityByStoreId(Long storeId);
//
//    ProductEntity getProductEntityById(Long productId);
}
