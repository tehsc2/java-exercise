package br.com.esther.product.adapters.datastore.ports.product;

import br.com.esther.product.adapters.datastore.ports.product.ProductAdapterEntity;

import java.util.List;
import java.util.UUID;

public interface ProductPort {

    List<ProductAdapterEntity> findByProductName(String name);

    ProductAdapterEntity findByProductId(UUID id);

    ProductAdapterEntity saveProduct(ProductAdapterEntity product);

    void deleteByProductId(UUID id);
}
