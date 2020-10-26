package br.com.esther.product.application.usecases.user.find;

import br.com.esther.product.adapters.datastore.exceptions.InvalidCredentialsException;
import br.com.esther.product.adapters.datastore.exceptions.NotFoundException;
import br.com.esther.product.adapters.datastore.ports.user.UserPort;
import br.com.esther.product.application.mapper.UserMapper;
import br.com.esther.product.application.usecases.FindUserUseCase;
import br.com.esther.product.domain.entities.User;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FindUserUseCaseImpl implements FindUserUseCase {

    private final UserPort userPort;
    private final UserMapper userMapper;

    @Override
    public List<User> findUsersByNameAndType(String name, String type) {
        return Optional.ofNullable(userPort.findUsersByNameAndType(name, type))
                .orElseThrow(() -> new NotFoundException("Users not founded"))
                .stream().map(userMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByStoreAndType(String store, String type) {
        List<User> users = Optional.ofNullable(userPort.findUsersByStoreAndType(store, type))
                .orElseThrow(() -> new NotFoundException("Users not founded"))
                .stream().map(userMapper::map).collect(Collectors.toList());

        users.sort(Comparator.comparing(User::getName));

        return users;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = Optional.ofNullable(userPort.findAllUsers())
                .orElseThrow(() -> new NotFoundException("Users not founded"))
                .stream().map(userMapper::map).collect(Collectors.toList());

        users.sort(Comparator.comparing(User::getName));

        return users;
    }

    @Override
    public void validateUserByEmailAndPassword(String login, String password) {
        Optional.ofNullable(userPort.findUserByEmailAndPassword(login, password))
                .orElseThrow(() -> new InvalidCredentialsException("Invalid Credentials"));
    }

}
