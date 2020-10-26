package br.com.esther.product.adapters.controllers.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductRequest {

    private UUID id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private Long stock;
    private String size;
    private String store;
    private BigDecimal commission;
}