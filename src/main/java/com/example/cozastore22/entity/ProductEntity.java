package com.example.cozastore22.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "images")
    private String images;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Column(name = "tags")
    private String tags;
    @ManyToOne
    @JoinColumn(name="id_category")
    private CategoryEntity category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<ProductDetailEntity> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailEntity> productDetails) {
        this.productDetails = productDetails;
    }

    @OneToMany(mappedBy = "product")
    private List<ProductDetailEntity> productDetails;
}
