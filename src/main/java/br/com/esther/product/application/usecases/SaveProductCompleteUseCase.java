package br.com.esther.product.application.usecases;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.application.mapper.ProductMapper;
import br.com.esther.product.domain.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class SaveProductCompleteUseCase {

    private final ProductMapper mapper;
    private final SaveProductUseCase useCase;

    public SaveProductCompleteUseCase(ProductMapper mapper, SaveProductUseCase useCase) {
        this.mapper = mapper;
        this.useCase = useCase;
    }

    public ProductResponse execute(ProductRequest productRequest) {
        Product product = useCase.saveProduct(Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .brand(productRequest.getBrand())
                .price(productRequest.getPrice())
                .build());

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .build();
    }
}
