package br.com.esther.product.application.usecases;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.domain.entities.Product;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SaveProductCompleteUseCaseTest {

    @InjectMocks
    SaveProductCompleteUseCase saveProductCompleteUseCase;

    @Mock
    SaveProductUseCase saveProductUseCase;

    @Test
    public void test_when_product_request_is_valid() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Product x");

        when(saveProductUseCase.saveProduct(any())).thenReturn(Product.builder()
                .id(UUID.randomUUID())
                .name(productRequest.getName())
                .build());

        assertNotNull(saveProductCompleteUseCase.execute(productRequest));
    }

    @Test(expected = InvalidFieldException.class)
    public void test_when_product_name_is_null() {
        ProductRequest productRequest = new ProductRequest();

        saveProductCompleteUseCase.execute(productRequest);
    }

    @Test(expected = InvalidFieldException.class)
    public void test_when_product_name_is_empty() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("");

        saveProductCompleteUseCase.execute(productRequest);
    }
}