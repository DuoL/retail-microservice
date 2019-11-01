package com.project.retail.service;

import com.project.retail.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repo;
    /**
     * Creates a store
     *
     * @param storeRequest to create store with
     * @return store created
     */
    public String create(String storeRequest) {
        return "creating a store by storeRequest name " + storeRequest;
    }

    /**
     * Get store list
     *
     * @param
     * @return list of stores
     */
    public String getStoreList() {
        return "get StoreEntity list";
    }

    /**
     * Get the store based on id
     *
     * @param storeId
     * @return store
     */
    public String getStoreById(Long storeId) {
        return "get store info by Id = " + storeId;
    }
}
