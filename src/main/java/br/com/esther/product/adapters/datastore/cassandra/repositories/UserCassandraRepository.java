package br.com.esther.product.adapters.datastore.cassandra.repositories;

import br.com.esther.product.adapters.datastore.cassandra.entities.UserCassandraEntity;
import br.com.esther.product.adapters.datastore.ports.user.UserAdapterEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface UserCassandraRepository extends CassandraRepository<UserCassandraEntity, UUID> {
    List<UserCassandraEntity> findAllByNameAndType(String name, String type);

    List<UserCassandraEntity> findAllByStoreAndType(String store, String type);

    UserCassandraEntity findByEmailAndPassword(String login, String password);
}
