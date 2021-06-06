package com.sivaone.example.persistence.entity;

import com.sivaone.example.persistence.OrderStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer Order entity.
 */
@Entity
@Getter
@Setter
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrderEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id", insertable=false, updatable=false)
  private CustomerEntity customerId;

  @OneToOne
  @JoinColumn(name = "id")
  private OrderEntity orderId;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime date;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
