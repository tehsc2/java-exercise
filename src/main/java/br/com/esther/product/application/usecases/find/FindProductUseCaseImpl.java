package br.com.esther.product.application.usecases.find;

import br.com.esther.product.adapters.datastore.ports.ProductPort;
import br.com.esther.product.application.mapper.ProductMapper;
import br.com.esther.product.application.usecases.FindProductUseCase;
import br.com.esther.product.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FindProductUseCaseImpl implements FindProductUseCase {

    private final ProductPort productPort;
    private final ProductMapper productMapper;

    @Autowired
    public FindProductUseCaseImpl(ProductPort productPort, ProductMapper productMapper) {
        this.productPort = productPort;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAllProductsBy(String name) {
        return productPort.findByProductName(name)
                .stream().map(productMapper::map).collect(Collectors.toList());
    }

    @Override
    public Product findById(UUID id) {
        return productMapper.map(productPort.findByProductId(id));
    }
}
