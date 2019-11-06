package com.project.retail.service;

import com.project.retail.domain.StoreEntity;
import com.project.retail.dto.Store;
import com.project.retail.dto.request.StoreRequest;
import com.project.retail.function.StoreConverter;
import com.project.retail.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repo;
    private final StoreConverter storeConverter;

    /**
     * Creates a store
     *
     * @param storeRequest to create store with
     * @return store created
     */
    public Store create(StoreRequest storeRequest) {
        StoreEntity entity = storeConverter.toEntity(storeRequest);
        return storeConverter.toDto(repo.save(entity));
    }

    /**
     * Get store list
     *
     * @return list of stores
     */
    public List<Store> getStoreList() {
        return repo.findAll()
                .stream()
                .map(x -> storeConverter.toDto(x))
                .collect(Collectors.toList());
    }

    /**
     * Get the store based on id
     *
     * @param storeId
     * @return store
     */
    public Store getStoreById(Long storeId) {
        StoreEntity storeEntity = repo.getOne(storeId);
        return storeConverter.toDto(storeEntity);
    }

    /**
     * Get the storeEntity based on id
     *
     * @param storeId
     * @return storeEntity
     */
    public StoreEntity getStoreEntityById(Long storeId) {
        StoreEntity existingEntity = repo.getOne(storeId);
        if (existingEntity == null) {
            throw new NoSuchElementException(String.format("Not found this store with this ID", storeId));
        }
        return existingEntity;
    }
}
