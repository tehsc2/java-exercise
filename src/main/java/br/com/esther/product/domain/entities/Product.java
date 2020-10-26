package br.com.esther.product.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Product {

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