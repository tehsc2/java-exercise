package br.com.esther.product.application.usecases;

import br.com.esther.product.domain.entities.User;

import java.util.List;

public interface FindUserUseCase {

    List<User> findUsersByNameAndType(String name, String type);

    List<User> findUsersByStoreAndType(String store, String type);

    List<User> findAllUsers();

    void validateUserByEmailAndPassword(String login, String password);


}
