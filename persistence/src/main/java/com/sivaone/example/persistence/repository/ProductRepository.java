package com.sivaone.example.persistence.repository;

import com.sivaone.example.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Product repository.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
