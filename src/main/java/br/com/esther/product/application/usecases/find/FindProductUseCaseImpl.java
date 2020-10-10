package br.com.esther.product.application.usecases.find;

import br.com.esther.product.application.usecases.FindProductUseCase;
import br.com.esther.product.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FindProductUseCaseImpl implements FindProductUseCase {

    @Override
    public List<Product> findAllProductsBy(String name) {
        return null;
    }

    @Override
    public Product findById(UUID id) {
        return null;
    }
}
