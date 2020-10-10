package br.com.esther.product.adapters.datastore.ports;

import java.util.List;

public interface ProductPort {

    List<ProductAdapterEntity> findByProductName(String name);

    ProductAdapterEntity findByProductId(Long id);

    ProductAdapterEntity saveProduct(ProductAdapterEntity product);
}
