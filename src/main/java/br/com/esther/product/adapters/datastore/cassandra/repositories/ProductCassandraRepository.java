package br.com.esther.product.adapters.datastore.cassandra.repositories;

import br.com.esther.product.adapters.datastore.cassandra.entities.ProductCassandraEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductCassandraRepository extends CassandraRepository<ProductCassandraEntity, Long> {
}
