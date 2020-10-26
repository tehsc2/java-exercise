package br.com.esther.product.adapters.datastore.cassandra.mapper;

import br.com.esther.product.adapters.datastore.cassandra.entities.UserCassandraEntity;
import br.com.esther.product.adapters.datastore.ports.user.UserAdapterEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserEntityMapper {
    UserAdapterEntity map(UserCassandraEntity userEntity);

    UserCassandraEntity map(UserAdapterEntity user);
}

