package com.sivaone.example.usecase;

import static org.junit.jupiter.api.Assertions.*;

import com.sivaone.example.domain.Customer;
import com.sivaone.example.domain.Dashboard;
import org.junit.jupiter.api.Test;

class GetCustomerOrdersUsecaseTest {

  @Test
  void testGetDashboard() {
    GetCustomerOrdersUsecase usecase = new GetCustomerOrdersUsecase();
    Customer customer = Customer.builder().name("John").email("john@john.com").build();
    Dashboard dashboard = usecase.getDashboard(customer);
    assertEquals(customer.getName(), dashboard.getCustomer().getName());
  }
}