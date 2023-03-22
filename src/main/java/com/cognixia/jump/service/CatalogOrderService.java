package com.cognixia.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.CatalogOrder;
import com.cognixia.jump.repository.CatalogOrderRepository;

@Service
public class CatalogOrderService {
    
    @Autowired
    CatalogOrderRepository coRepo;

    public List<CatalogOrder> getAllCatalogOrders(){
        return coRepo.findAll();
    }
}
