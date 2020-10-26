package br.com.esther.product.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String name;
    private Long age;
    private String phone;
    private String address;
    private List<String> stores;
    private List<String> type;
    private BigDecimal comission;

}
