package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.CatalogOrder;

@Repository
public interface CatalogOrderRepository extends JpaRepository<CatalogOrder, Integer> {
    
    @Query("select c from CatalogOrder c where c.catalog.id = ?1 and e.order.id = ?2")
    public Optional<CatalogOrder> catalogOrdered(int catalogId, int orderId);
}
