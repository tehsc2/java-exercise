package br.com.esther.product.adapters.datastore.ports;

import br.com.esther.product.domain.entities.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductAdapterEntity {

    private UUID id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;

    ProductAdapterEntity(UUID id, String name, String description, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public static ProductAdapterEntity.ProductAdapterEntityBuilder builder() {
        return new ProductAdapterEntity.ProductAdapterEntityBuilder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static class ProductAdapterEntityBuilder {
        private UUID id;
        private String name;
        private String description;
        private String brand;
        private BigDecimal price;

        ProductAdapterEntityBuilder() {
        }

        public ProductAdapterEntity.ProductAdapterEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ProductAdapterEntity.ProductAdapterEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductAdapterEntity.ProductAdapterEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductAdapterEntity.ProductAdapterEntityBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductAdapterEntity.ProductAdapterEntityBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductAdapterEntity build() {
            return new ProductAdapterEntity(id, name, description, brand, price);
        }
    }
}
