package com.cloudone.astores.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @Column(nullable = false, length = 15)
    private Date date;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(Set<Product> products, Date date, Double amount, User user) {
        this.products = products;
        this.date = date;
        this.amount = amount;
        this.user = user;
    }
}
