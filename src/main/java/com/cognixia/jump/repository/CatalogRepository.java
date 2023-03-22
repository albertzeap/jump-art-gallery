package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    
}
