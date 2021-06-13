package com.sivaone.example.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Product entity.
 */
@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class ProductEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String name;

  @Column
  private Double price;
}
