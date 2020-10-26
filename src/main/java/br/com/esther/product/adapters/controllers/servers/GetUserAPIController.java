package br.com.esther.product.adapters.controllers.servers;

import br.com.esther.product.adapters.datastore.exceptions.InvalidCredentialsException;
import br.com.esther.product.adapters.datastore.exceptions.NotFoundException;
import br.com.esther.product.application.usecases.FindUserUseCase;
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

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class GetUserAPIController {

    private static final Log LOGGER = LogFactory.getLog(GetUserAPIController.class);
    private final FindUserUseCase findUserUseCase;

    @GetMapping(value = "users")
    public ResponseEntity<Object> getUsersBy(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "store", required = false) String store,
            @RequestParam(value = "type", required = false) String type) {
        try {
            LOGGER.info("Getting users...");

            String typeValid = Optional.ofNullable(type).orElse("CLIENT");

            if (store != null && !store.isEmpty()) {
                return ResponseEntity.ok(findUserUseCase.findUsersByStoreAndType(store, typeValid));
            } else if (name != null && !name.isEmpty()) {
                return ResponseEntity.ok(findUserUseCase.findUsersByNameAndType(name, typeValid));
            }

            return ResponseEntity.ok(findUserUseCase.findAllUsers());
        } catch (InvalidFieldException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("user/validate")
    public ResponseEntity loginValidator(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        try {
            LOGGER.info("Validating user...");

            findUserUseCase.validateUserByEmailAndPassword(email, password);
            return ResponseEntity.ok().build();
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
