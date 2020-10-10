package br.com.esther.product.application.usecases;

import br.com.esther.product.domain.entities.Product;

public interface SaveProductUseCase {

    Product saveProduct(Product product);

    void updateProductName(Long id, String newName);
}
