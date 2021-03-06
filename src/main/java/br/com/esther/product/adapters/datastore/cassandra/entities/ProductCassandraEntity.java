package br.com.esther.product.adapters.datastore.cassandra.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table(value = ProductCassandraEntity.TABLE_NAME)
@Data
public class ProductCassandraEntity {
    public static final String TABLE_NAME = "product";

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Id
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
