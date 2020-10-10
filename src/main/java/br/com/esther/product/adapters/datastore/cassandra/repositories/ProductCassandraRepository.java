package br.com.esther.product.adapters.datastore.cassandra.repositories;

import br.com.esther.product.adapters.datastore.cassandra.entities.ProductCassandraEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductCassandraRepository extends CassandraRepository<ProductCassandraEntity, UUID> {
    List<ProductCassandraEntity> findByName(String name);
}
