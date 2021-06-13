package com.sivaone.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {

  private final String name;
  private final String email;
}
