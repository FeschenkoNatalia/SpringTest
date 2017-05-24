package com.brina.model;

import javax.persistence.*;

@Entity
@Table (name = "products2")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column (name = "description")
    private String description;

    @Column (name = "price", nullable = false)
    private Double price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory(){ return category;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
