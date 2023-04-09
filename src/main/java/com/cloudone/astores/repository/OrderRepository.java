package com.cloudone.astores.repository;

import com.cloudone.astores.entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
