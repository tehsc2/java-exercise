package br.com.esther.product.application.usecases.find;

import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.application.mapper.ProductDTOMapper;
import br.com.esther.product.application.usecases.FindProductUseCase;
import br.com.esther.product.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterProductUseCase {

    private final FindProductUseCase productUseCase;
    private final ProductDTOMapper productDTOMapper;

    @Autowired
    public FilterProductUseCase(FindProductUseCase productUseCase, ProductDTOMapper productDTOMapper) {
        this.productUseCase = productUseCase;
        this.productDTOMapper = productDTOMapper;
    }

    public List<ProductResponse> findBy(String name) {
        if (name == null){
            name = "";
        }

        List<Product> products = productUseCase.findAllProductsBy(name);

        return products.stream().map(productDTOMapper::map).collect(Collectors.toList());

    }

}
