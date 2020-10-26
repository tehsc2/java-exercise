package br.com.esther.product.adapters.datastore.cassandra.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table(value = UserCassandraEntity.TABLE_NAME)
@Data
public class UserCassandraEntity {

    public static final String TABLE_NAME = "user";

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Id
    private UUID id;
    private String name;
    private Long age;
    private String phone;
    private String address;
    private List<String> stores;
    private List<String> type;
    private BigDecimal comission;
}
