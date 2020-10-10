package br.com.esther.product.application.mapper;

import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import br.com.esther.product.domain.entities.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProductMapper {

    Product map(ProductAdapterEntity productAdapterEntity);

    ProductAdapterEntity map(Product product);

}
