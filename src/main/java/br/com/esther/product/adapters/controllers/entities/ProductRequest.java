package br.com.esther.product.adapters.controllers.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRequest {
    private UUID id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;

    public ProductRequest() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getBrand() {
        return this.brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
