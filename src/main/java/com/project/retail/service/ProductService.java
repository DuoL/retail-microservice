package com.project.retail.service;

import com.project.retail.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    /**
     * Creates a product
     *
     * @param storeId to  create a product
     * @return product created
     */
    public String create( Long storeId) {
        return "creating product for this store " + storeId;
    }

    /**
     * Get a list of products by storeId
     *
     * @param storeId
     * @return a list of products
     */
    public String getProductListByStoreId(Pageable pageable, Long storeId) {
       // TO do find it by store Id
        return "getting product List by storeId " + storeId;
    }

    /**
     * Get the product by its storeId
     *
     * @param storeId
     * @return product info
     */
    public String getProductById(Long storeId, Long productId) {
        return "getting " + productId + " product info by storeId " + storeId;
    }
}
