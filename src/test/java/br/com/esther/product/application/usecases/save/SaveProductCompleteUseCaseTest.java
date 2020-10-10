package br.com.esther.product.application.usecases.save;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.application.mapper.ProductDTOMapper;
import br.com.esther.product.application.usecases.SaveProductUseCase;
import br.com.esther.product.domain.entities.Product;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SaveProductCompleteUseCaseTest {

    @InjectMocks
    SaveOrUpdateProductUseCase saveProductCompleteUseCase;

    @Mock
    ProductDTOMapper productMapper;

    @Mock
    SaveProductUseCase saveProductUseCase;

    @Test
    public void test_when_product_request_is_valid() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Product x");

        UUID id = UUID.randomUUID();
        when(productMapper.map(any(Product.class))).thenReturn(ProductResponse.builder()
                .id(id)
                .name(productRequest.getName())
                .build());

        when(saveProductUseCase.saveProduct(any())).thenReturn(Product.builder()
                .id(id)
                .name(productRequest.getName())
                .build());

        assertNotNull(saveProductCompleteUseCase.executeCompleteSave(productRequest));
    }

    @Test(expected = InvalidFieldException.class)
    public void test_when_product_name_is_null() {
        ProductRequest productRequest = new ProductRequest();

        saveProductCompleteUseCase.executeCompleteSave(productRequest);
    }

    @Test(expected = InvalidFieldException.class)
    public void test_when_product_name_is_empty() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("");

        saveProductCompleteUseCase.executeCompleteSave(productRequest);
    }

    @Test
    public void test_success_when_update_name() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(UUID.randomUUID());
        productRequest.setName("Product x");

        when(productMapper.map(any(Product.class))).thenReturn(ProductResponse.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .build());

        when(saveProductUseCase.updateProductName(productRequest.getId(), productRequest.getName())).thenReturn(Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .price(BigDecimal.valueOf(10))
                .description("XXX")
                .brand("Esther")
                .build());

        assertNotNull(saveProductCompleteUseCase.executeOnlyNameUpdate(productRequest));
    }

    @Test(expected = InvalidFieldException.class)
    public void test_failed_null_id_when_update_name() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(null);
        productRequest.setName("Product x");

        saveProductCompleteUseCase.executeOnlyNameUpdate(productRequest);
    }
}