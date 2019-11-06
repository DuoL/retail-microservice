package com.project.retail.function;

import com.project.retail.domain.OrderEntity;
import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Product;
import com.project.retail.dto.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductConverter {
    public Product toDto(ProductEntity productEntity) {
        Product result = new Product();
        if (productEntity.getOrder() != null) {
            result.setOrderId(productEntity.getOrder().getOrderId());
        }
        result.setDescription(productEntity.getDescription());
        result.setPrice(productEntity.getPrice());
        result.setProductId(productEntity.getProductId());
        result.setSku(productEntity.getSku());
        result.setStoreId(productEntity.getStore().getStoreId());
        result.setProductName(productEntity.getProductName());
        return result;
    }

    public ProductEntity toEntity(
            ProductRequest productRequest,
            StoreEntity storeEntity,
            OrderEntity orderEntity) {
        ProductEntity productEntity = ProductEntity
                .builder()
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .sku(productRequest.getSku())
                .store(storeEntity)
                .order(orderEntity)
                .build();
        if (productRequest.getProductId() != null) {
            productEntity.setProductId(productRequest.getProductId());
        }
        return productEntity;
    }
}
