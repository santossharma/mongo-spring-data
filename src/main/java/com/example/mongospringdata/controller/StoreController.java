package com.example.mongospringdata.controller;

import com.example.mongospringdata.exception.ResourceNotFoundException;
import com.example.mongospringdata.model.Store;
import com.example.mongospringdata.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable String id) {
        return storeService.getStoreById(id);
    }

    @GetMapping("/email/{email}")
    public Store getStoreByEmail(@PathVariable String email) {
        return storeService.getStoreByEmail(email);
    }

    @PostMapping
    public List<Store> addStores(@RequestBody List<Store> storeList) {
        return storeService.saveStores(storeList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStoreById(@PathVariable String id) {
        try {
            storeService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public Page<Store> getStoresBySearchText(@RequestParam(required = false, defaultValue = "") String searchText,
                                              @RequestParam(required = false, defaultValue = "0") Integer page,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageSize) {
        return storeService.findStoresBySearchText(searchText, page, pageSize);
    }
}
