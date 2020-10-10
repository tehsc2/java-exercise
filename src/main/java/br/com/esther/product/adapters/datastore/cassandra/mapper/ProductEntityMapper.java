package br.com.esther.product.adapters.datastore.cassandra.mapper;

import br.com.esther.product.adapters.datastore.cassandra.entities.ProductCassandraEntity;
import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProductEntityMapper {
    ProductAdapterEntity map(ProductCassandraEntity productEntity);

    ProductCassandraEntity map(ProductAdapterEntity product);
}
