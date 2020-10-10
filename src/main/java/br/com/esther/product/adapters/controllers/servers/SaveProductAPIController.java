package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.controllers.entities.ProductRequest;
import br.com.esther.product.adapters.datastore.exceptions.ProductNotFoundException;
import br.com.esther.product.application.usecases.save.SaveOrUpdateProductUseCase;
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
    private final SaveOrUpdateProductUseCase saveProductCompleteUseCase;

    public SaveProductAPIController(SaveOrUpdateProductUseCase saveProductCompleteUseCase) {
        this.saveProductCompleteUseCase = saveProductCompleteUseCase;
    }

    @PostMapping(value = "product")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductRequest productRequest) {
        try {
            LOGGER.info("Request Received");
            return ResponseEntity.ok(saveProductCompleteUseCase.executeCompleteSave(productRequest));
        } catch (InvalidFieldException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "product")
    public ResponseEntity<Object> updateProductName(@RequestBody ProductRequest productRequest) {
        try {
            LOGGER.info("Request Received");

            return ResponseEntity.ok(saveProductCompleteUseCase.executeOnlyNameUpdate(productRequest));
        } catch (InvalidFieldException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
