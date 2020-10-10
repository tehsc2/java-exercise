package br.com.esther.product.adapters.controllers.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

    private UUID id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;

    ProductResponse(UUID id, String name, String description, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public static ProductResponseBuilder builder() {
        return new ProductResponseBuilder();
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

    public static class ProductResponseBuilder {
        private UUID id;
        private String name;
        private String description;
        private String brand;
        private BigDecimal price;

        ProductResponseBuilder() {
        }

        public ProductResponse.ProductResponseBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ProductResponse.ProductResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductResponse.ProductResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductResponse.ProductResponseBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductResponse.ProductResponseBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(id, name, description, brand, price);
        }
    }
}
