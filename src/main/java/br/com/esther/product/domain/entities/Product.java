package br.com.esther.product.domain.entities;

import br.com.esther.product.domain.exceptions.InvalidFieldException;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;

    Product(UUID id, String name, String description, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
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

    public static class ProductBuilder {
        private UUID id;
        private String name;
        private String description;
        private String brand;
        private BigDecimal price;

        ProductBuilder() {
        }

        public ProductBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = Optional.ofNullable(name).filter(n -> !n.trim().isEmpty()).orElseThrow(() -> new InvalidFieldException("Field name is required"));
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(id, name, description, brand, price);
        }
    }
}
