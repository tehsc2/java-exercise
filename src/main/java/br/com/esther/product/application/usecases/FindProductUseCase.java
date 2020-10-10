package br.com.esther.product.application.usecases;

import br.com.esther.product.domain.entities.Product;

import java.util.List;
import java.util.UUID;

public interface FindProductUseCase {

    List<Product> findAllProductsBy(String name);

    Product findById(UUID id);
}
