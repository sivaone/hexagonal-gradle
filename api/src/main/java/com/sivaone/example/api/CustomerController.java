package com.sivaone.example.api;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Customer API.
 */
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

  /**
   * Get customer details.
   *
   * @param id customer id
   * @return Customer details
   */
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, String>> findCustomer(@PathVariable String id) {
    return ResponseEntity.ok(Map.of("id", id));
  }
}
