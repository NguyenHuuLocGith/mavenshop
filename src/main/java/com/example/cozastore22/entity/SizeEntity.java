package com.example.cozastore22.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDetailEntity> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailEntity> productDetails) {
        this.productDetails = productDetails;
    }

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "size")
    private List<ProductDetailEntity> productDetails;
}
