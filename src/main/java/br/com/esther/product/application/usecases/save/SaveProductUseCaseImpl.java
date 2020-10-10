package br.com.esther.product.application.usecases.save;

import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import br.com.esther.product.adapters.datastore.ports.ProductPort;
import br.com.esther.product.application.mapper.ProductMapper;
import br.com.esther.product.application.usecases.SaveProductUseCase;
import br.com.esther.product.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveProductUseCaseImpl implements SaveProductUseCase {

    private final ProductPort productPort;
    private final ProductMapper productMapper;

    @Autowired
    public SaveProductUseCaseImpl(ProductPort productPort, ProductMapper productMapper) {
        this.productPort = productPort;
        this.productMapper = productMapper;
    }

    @Override
    public Product saveProduct(Product product) {
        return productMapper.map(
                productPort.saveProduct(
                        productMapper.map(product)));
    }

    @Override
    public void updateProductName(Long id, String newName) {
        ProductAdapterEntity product = productPort.findByProductId(id);
        product.setName(newName);
        productPort.saveProduct(product);
    }
}
