package br.com.esther.product.adapters.datastore.cassandra.services;

import br.com.esther.product.adapters.datastore.cassandra.mapper.UserEntityMapper;
import br.com.esther.product.adapters.datastore.cassandra.repositories.UserCassandraRepository;
import br.com.esther.product.adapters.datastore.ports.user.UserAdapterEntity;
import br.com.esther.product.adapters.datastore.ports.user.UserPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserCassandraServiceImpl implements UserPort {

    private final UserCassandraRepository userCassandraRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public List<UserAdapterEntity> findUsersByNameAndType(String name, String type) {
        return userCassandraRepository.findAllByNameAndType(name, type)
                .stream().map(userEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAdapterEntity> findUsersByStoreAndType(String store, String type) {
        return userCassandraRepository.findAllByStoreAndType(store, type)
                .stream().map(userEntityMapper::map).collect(Collectors.toList());
    }

    @Override
    public UserAdapterEntity findUserByEmailAndPassword(String login, String password) {
        return userEntityMapper.map(userCassandraRepository.findByEmailAndPassword(login, password));
    }

    @Override
    public List<UserAdapterEntity> findAllUsers() {
        return userCassandraRepository.findAll().stream()
                .map(userEntityMapper::map).collect(Collectors.toList());
    }
}
