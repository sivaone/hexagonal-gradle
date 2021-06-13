package com.sivaone.example.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer entity.
 */
@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class CustomerEntity {
  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String email;
}
