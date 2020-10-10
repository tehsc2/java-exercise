package br.com.esther.product.application.usecases.delete;

import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.adapters.datastore.ports.ProductPort;
import br.com.esther.product.application.mapper.ProductDTOMapper;
import br.com.esther.product.application.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteProductUseCase {

    private final ProductPort productPort;
    private final ProductMapper productMapper;
    private final ProductDTOMapper productDTOMapper;

    public DeleteProductUseCase(ProductPort productPort, ProductMapper productMapper, ProductDTOMapper productDTOMapper) {
        this.productPort = productPort;
        this.productMapper = productMapper;
        this.productDTOMapper = productDTOMapper;
    }

    public void execute(UUID id) {
        productPort.deleteByProductId(id);
    }
}
