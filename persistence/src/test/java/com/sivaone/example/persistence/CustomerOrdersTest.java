package com.sivaone.example.persistence;

import com.sivaone.example.persistence.config.PersistenceTestConfig;
import com.sivaone.example.persistence.entity.CustomerOrderEntity;
import com.sivaone.example.persistence.entity.ProductEntity;
import com.sivaone.example.persistence.repository.CustomerOrderRepository;
import com.sivaone.example.persistence.repository.ProductRepository;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = {PersistenceTestConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@SuppressWarnings({"PMD.BeanMembersShouldSerialize"})
class CustomerOrdersTest {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private CustomerOrderRepository customerOrderRepository;

  @Test
  void testSaveAndGetProducts() {
    ProductEntity product = new ProductEntity();
    product.setName("iPhone");
    product.setPrice(700.0d);

    ProductEntity productEntity = productRepository.save(product);
    Assertions.assertNotNull(productEntity.getId());

  }

  @Test
  void testCustomerOrders() {
    CustomerOrders customerOrders = new CustomerOrders(customerOrderRepository);
    Assertions
        .assertThrows(EntityNotFoundException.class,
            () -> customerOrders.getCustomerOrder(101L));
  }

}