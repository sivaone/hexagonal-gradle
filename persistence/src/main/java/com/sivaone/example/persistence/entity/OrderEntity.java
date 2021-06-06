package com.sivaone.example.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Order entity.
 */
@Entity
@Getter
@Setter
@Table(name = "ORDER")
public class OrderEntity {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "id", insertable=false, updatable=false)
  private ProductEntity productId;

  @NotNull
  private Integer quantity;
}
