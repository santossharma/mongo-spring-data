package com.example.mongospringdata.service;

import com.example.mongospringdata.exception.ResourceNotFoundException;
import com.example.mongospringdata.model.Store;
import com.example.mongospringdata.repository.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(String storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "storeId", storeId));
    }

    public Store getStoreByEmail(String email) {
        return storeRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "email", email));
    }

    public List<Store> saveStores(List<Store> storeList) {
        return storeRepository.saveAll(storeList);
    }

    public void deleteById(String id) {
        if(storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Store", "storeId", id);
        }
    }

    public Page<Store> findStoresBySearchText(String searchText, Integer page, Integer pageSize) {
        Page<Store> searchResults;
        if (searchText.isEmpty()) {
            Pageable pageable = PageRequest.of(page, pageSize);
            searchResults = storeRepository.findAll(pageable);
        } else {
            Sort sort = Sort.by("score");
            Pageable pageable = PageRequest.of(page, pageSize, sort);
            TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(searchText);

            searchResults = storeRepository.findAllBy(criteria, pageable);
        }

        return searchResults;
    }
}
