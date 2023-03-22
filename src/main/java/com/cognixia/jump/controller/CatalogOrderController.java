package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.CatalogOrder;
import com.cognixia.jump.service.CatalogOrderService;

@RestController
@RequestMapping("/api")
public class CatalogOrderController {
    
    @Autowired
    CatalogOrderService coService;

    @GetMapping("/catalogOrder")
    public ResponseEntity<?> getAllCatalogOrders(){
        List<CatalogOrder> found = coService.getAllCatalogOrders();

        if(found.isEmpty()){
            return ResponseEntity.status(400).body("No Catalogs have been ordered");
        }

        return ResponseEntity.status(200).body(found);
    }
}
