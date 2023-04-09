package com.cloudone.astores.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 15)
    private String category;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private Double price;

    public Product(String name, String category, String img, Double price) {
        this.name = name;
        this.category = category;
        this.img = img;
        this.price = price;
    }

    public Product(Integer id){
        this.id = id;
    }
}
