package br.com.esther.product.application.usecases;

import br.com.esther.product.domain.entities.Product;

import java.util.UUID;

public interface SaveProductUseCase {

    Product saveProduct(Product product);

    Product updateProductName(UUID id, String newName);
}
