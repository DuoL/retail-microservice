package com.project.retail.service;

import com.project.retail.domain.ProductEntity;
import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Product;
import com.project.retail.dto.request.ProductRequest;
import com.project.retail.function.ProductConverter;
import com.project.retail.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;
    private final StoreService storeService;
    private final ProductConverter productConverter;

    /**
     * Creates a product
     *
     * @param storeId to  create a product
     * @return product created
     */
    public Product create(Long storeId, ProductRequest productRequest) {
        StoreEntity storeEntity = storeService.getStoreEntityById(storeId);
        ProductEntity productEntity = productConverter.toEntity(productRequest, storeEntity);
        return productConverter.toDto(repo.save(productEntity));
    }

    /**
     * Get a list of products by storeId
     *
     * @param storeId
     * @return a list of products
     */
    public List<Product> getProductListByStoreId(Long storeId) {
        return storeService.getStoreById(storeId).getProductList();
    }

    /**
     * Get the product by its storeId
     * @param productId
     * @return product info
     */
    public Product getProductById(Long productId) {
        return productConverter.toDto(repo.getOne(productId));
    }


    /**
     * Get the productEntity based on id
     *
     * @param productId
     * @return productEntity
     */
    public ProductEntity getProductEntityById(Long productId) {
        return repo.getOne(productId);
    }
}
