package com.project.retail.service;

import com.project.retail.domain.StoreEntity;
import com.project.retail.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        StoreEntity storeEntity = StoreEntity.builder().storeName(storeRequest).build();
        repo.save(storeEntity);
        return "creating a store by storeRequest name " + storeRequest;
    }

    /**
     * Get store list
     *
     * @param
     * @return list of stores
     */
    public String getStoreList() {
        List<StoreEntity> res = repo.findAll();
        StringBuilder sb = new StringBuilder();
        for (StoreEntity se : res) {
            sb.append(se.getStoreName()).append("/n");
        }
        return sb.toString();
    }

    /**
     * Get the store based on id
     *
     * @param storeId
     * @return store
     */
    public String getStoreById(Long storeId) {
        return repo.getOne(storeId).getStoreName();
    }
}
