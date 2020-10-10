package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.controllers.entities.ProductResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductAPIController {

    private static final Log LOGGER = LogFactory.getLog(SaveProductAPIController.class);

    @GetMapping(value = "products")
    public ResponseEntity<ProductResponse> getProducts(
            @RequestParam(value = "name", required = false) String name
    ){
        LOGGER.info("Get products order by name");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "product/{id_product}")
    public ResponseEntity<ProductResponse> getProductById(){
        LOGGER.info("Get product by id");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
