package com.sivaone.example.persistence.repository;

import com.sivaone.example.persistence.entity.CustomerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Customer Order repository.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {

}
