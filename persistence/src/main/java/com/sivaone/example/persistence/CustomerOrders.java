package com.sivaone.example.persistence;

import com.sivaone.example.persistence.entity.CustomerOrderEntity;
import com.sivaone.example.persistence.repository.CustomerOrderRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Customer orders.
 */
@Component
@RequiredArgsConstructor
public class CustomerOrders {
  private final CustomerOrderRepository customerOrderRepository;

  /**
   * Get customer order by id.
   *
   * @param id order id
   * @return Customer Order object
   */
  public CustomerOrderEntity getCustomerOrder(Long id) {
    Optional<CustomerOrderEntity> customerOrderEntity = customerOrderRepository.findById(id);
    return customerOrderEntity.orElseThrow(EntityNotFoundException::new);
  }
}
