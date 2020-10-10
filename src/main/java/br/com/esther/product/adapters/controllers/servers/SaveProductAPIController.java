package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.application.usecases.SaveProductCompleteUseCase;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SaveProductAPIController {

    private static final Log LOGGER = LogFactory.getLog(SaveProductAPIController.class);
    private final SaveProductCompleteUseCase saveProductCompleteUseCase;

    public SaveProductAPIController(SaveProductCompleteUseCase saveProductCompleteUseCase) {
        this.saveProductCompleteUseCase = saveProductCompleteUseCase;
    }

    @PostMapping(value = "product")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductRequest productRequest) {
        LOGGER.info("Save a product and return the product with id");
        try{
            return ResponseEntity.ok(saveProductCompleteUseCase.execute(productRequest));
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "product/{id_product}")
    public ResponseEntity<ProductResponse> updateProductName() {
        LOGGER.info("Save a product and return the product with id");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
