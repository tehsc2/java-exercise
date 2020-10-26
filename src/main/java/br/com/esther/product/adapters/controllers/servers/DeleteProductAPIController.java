package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.datastore.exceptions.NotFoundException;
import br.com.esther.product.application.usecases.product.delete.DeleteProductUseCase;
import br.com.esther.product.domain.exceptions.InvalidFieldException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin("*")
public class DeleteProductAPIController {

    private static final Log LOGGER = LogFactory.getLog(DeleteProductAPIController.class);
    private final DeleteProductUseCase deleteProductUseCase;

    public DeleteProductAPIController(DeleteProductUseCase deleteProductUseCase) {
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @DeleteMapping("/product")
    public ResponseEntity<Object> deleteProduct(@RequestParam(value = "id", required = true) UUID id){
        try{
            LOGGER.info("Deleting product...");

            deleteProductUseCase.execute(id);
            return ResponseEntity.ok().body("Deleted with success");
        }catch (InvalidFieldException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            LOGGER.error("Can't delete the product");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }
}
