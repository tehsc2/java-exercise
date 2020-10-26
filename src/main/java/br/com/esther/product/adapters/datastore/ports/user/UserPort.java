package br.com.esther.product.adapters.datastore.ports.user;

import java.util.List;

public interface UserPort {

    List<UserAdapterEntity> findUsersByNameAndType(String name, String type);

    List<UserAdapterEntity> findUsersByStoreAndType(String store, String type);

    UserAdapterEntity findUserByEmailAndPassword(String login, String password);

    List<UserAdapterEntity> findAllUsers();
}
