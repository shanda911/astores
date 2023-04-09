package com.cloudone.astores.controller;


import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import com.cloudone.astores.entitiy.User;
import com.cloudone.astores.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController{
    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    @PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER',)")
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER',)")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok().body(repository.findById(id));
    }


}
