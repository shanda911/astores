package com.cloudone.astores.repository;

import com.cloudone.astores.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
