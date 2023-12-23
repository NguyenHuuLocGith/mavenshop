package com.example.cozastore22.entity;

import jakarta.persistence.*;

@Entity(name = "productdetail")
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_detail")
    private int idProductDetail;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private String desc;
    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    public int getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(int idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    @ManyToOne
    @JoinColumn(name="id_product")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private SizeEntity size;

}
