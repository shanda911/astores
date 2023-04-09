package com.cloudone.astores.controller;


import com.cloudone.astores.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping("/orders")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/orders/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")
    public ResponseEntity<?> getOrder(Integer id) {
        return ResponseEntity.ok().body(repository.findById(id));
    }


}
