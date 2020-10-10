package br.com.esther.product.application.usecases.save;

import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import br.com.esther.product.adapters.datastore.ports.ProductPort;
import br.com.esther.product.application.mapper.ProductMapper;
import br.com.esther.product.domain.entities.Product;
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
public class SaveProductUseCaseImplTest {

    @InjectMocks
    SaveProductUseCaseImpl saveProductUseCase;

    @Mock
    ProductMapper productMapper;

    @Mock
    ProductPort productPort;

    @Test
    public void saveProduct() {
        Product product = Product.builder()
                .name("Product x")
                .brand("Esther")
                .description("Nothing")
                .price(new BigDecimal(10.0))
                .build();

        ProductAdapterEntity productAdapterEntity = ProductAdapterEntity.builder()
                .id(UUID.randomUUID())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .build();

        saveProductUseCase = new SaveProductUseCaseImpl(productPort, productMapper);

        when(productPort.saveProduct(any())).thenReturn(productAdapterEntity);

        when(productMapper.map(productAdapterEntity)).thenReturn(product);

        assertNotNull(saveProductUseCase.saveProduct(product));
    }
}