package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.datastore.exceptions.NotFoundException;
import br.com.esther.product.application.usecases.product.find.FilterProductUseCase;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class GetProductAPIController {

    private static final Log LOGGER = LogFactory.getLog(GetProductAPIController.class);
    private final FilterProductUseCase filterProductUseCase;

    @GetMapping(value = "products")
    public ResponseEntity<Object> getProducts(
            @RequestParam(value = "name", required = false) String name) {
        try{
            LOGGER.info("Getting products...");

            return ResponseEntity.ok(filterProductUseCase.findBy(name));
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "product")
    public ResponseEntity<Object> getProductById(@RequestParam(value = "id", required = true) UUID id) {
        try{
            LOGGER.info("Getting product by id...");

            return ResponseEntity.ok(filterProductUseCase.findById(id));
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
