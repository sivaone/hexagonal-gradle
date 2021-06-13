package com.sivaone.example.usecase;

import com.sivaone.example.domain.Customer;
import com.sivaone.example.domain.Dashboard;
import com.sivaone.example.domain.Order;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Get customer orders implementation.
 */
public class GetCustomerOrdersUsecase {

  public Dashboard getDashboard(Customer customer) {
    Order order = Order.builder()
        .status("Open")
        .orderedDate(LocalDateTime.now())
        .build();
    Dashboard dashboard = Dashboard.builder()
        .customer(customer)
        .orders(List.of(order))
        .build();

    return dashboard;
  }
}
