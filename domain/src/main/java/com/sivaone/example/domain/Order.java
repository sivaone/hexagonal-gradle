package com.sivaone.example.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {

  private final Long orderId;
  private final String status;
  private final LocalDateTime orderedDate;
}
