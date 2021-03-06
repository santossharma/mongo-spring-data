package com.example.mongospringdata.repository;

import com.example.mongospringdata.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {

    Optional<Store> findByEmail(String email);
    Page<Store> findAllBy(TextCriteria textCriteria, Pageable pageable);
}
