package br.com.esther.product.adapters.datastore.cassandra.mapper;

import br.com.esther.product.adapters.datastore.cassandra.entities.ProductCassandraEntity;
import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public abstract class ProductEntityMapper {

    public abstract ProductAdapterEntity map(ProductCassandraEntity productEntity);

    public abstract ProductCassandraEntity map(ProductAdapterEntity product);
}
