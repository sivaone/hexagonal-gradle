package com.sivaone.example.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Dashboard {
  private Customer customer;
  private List<Order> orders;
}
