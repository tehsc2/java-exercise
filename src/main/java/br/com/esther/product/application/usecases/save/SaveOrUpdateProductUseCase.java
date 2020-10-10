package br.com.esther.product.application.usecases.save;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.application.mapper.ProductDTOMapper;
import br.com.esther.product.application.mapper.ProductMapper;
import br.com.esther.product.application.usecases.SaveProductUseCase;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveOrUpdateProductUseCase {

    private final ProductMapper mapper;
    private final ProductDTOMapper productDTOMapper;
    private final SaveProductUseCase useCase;

    @Autowired
    public SaveOrUpdateProductUseCase(ProductMapper mapper, ProductDTOMapper productDTOMapper, SaveProductUseCase useCase) {
        this.mapper = mapper;
        this.productDTOMapper = productDTOMapper;
        this.useCase = useCase;
    }

    public ProductResponse executeCompleteSave(ProductRequest productRequest) {
        Optional.ofNullable(productRequest)
                .filter(p -> p.getName() != null && !p.getName().trim().isEmpty())
                .orElseThrow(() -> new InvalidFieldException("Field Name is required"));

        return productDTOMapper.map(useCase.saveProduct(productDTOMapper.map(productRequest)));
    }

    public ProductResponse executeOnlyNameUpdate(ProductRequest productRequest) {
        Optional.ofNullable(productRequest)
                .filter(p -> p.getId() != null && p.getName() != null && !p.getName().isEmpty())
                .orElseThrow(() -> new InvalidFieldException("Field ID and NAME is required"));

        return productDTOMapper.map(useCase.updateProductName(productRequest.getId(), productRequest.getName()));
    }
}
