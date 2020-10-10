package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import br.com.esther.product.adapters.datastore.exceptions.ProductNotFoundException;
import br.com.esther.product.application.usecases.find.FilterProductUseCase;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class GetProductAPIController {

    private static final Log LOGGER = LogFactory.getLog(GetProductAPIController.class);
    private final FilterProductUseCase filterProductUseCase;

    public GetProductAPIController(FilterProductUseCase filterProductUseCase) {
        this.filterProductUseCase = filterProductUseCase;
    }

    @GetMapping(value = "products")
    public ResponseEntity<Object> getProducts(
            @RequestParam(value = "name", required = false) String name) {
        try{
            LOGGER.info("Getting products...");

            return ResponseEntity.ok(filterProductUseCase.findBy(name));
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "product/{id_product}")
    public ResponseEntity<Object> getProductById(@PathVariable("id_product") UUID id) {
        try{
            LOGGER.info("Getting product by id...");

            return ResponseEntity.ok(filterProductUseCase.findById(id));
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
