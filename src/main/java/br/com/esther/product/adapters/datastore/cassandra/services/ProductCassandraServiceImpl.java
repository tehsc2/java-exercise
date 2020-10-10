package br.com.esther.product.adapters.datastore.cassandra.services;

import br.com.esther.product.adapters.datastore.cassandra.mapper.ProductEntityMapper;
import br.com.esther.product.adapters.datastore.cassandra.repositories.ProductCassandraRepository;
import br.com.esther.product.adapters.datastore.exceptions.ProductNotFoundException;
import br.com.esther.product.adapters.datastore.ports.ProductAdapterEntity;
import br.com.esther.product.adapters.datastore.ports.ProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCassandraServiceImpl implements ProductPort {

    @Autowired
    private ProductCassandraRepository repository;
    @Autowired
    private ProductEntityMapper mapper;

    @Override
    public List<ProductAdapterEntity> findByProductName(String name) {
        if (!name.trim().isEmpty()){
            return Optional.ofNullable(repository.findByName(name))
                    .filter(list -> !list.isEmpty())
                    .orElseThrow(() -> new ProductNotFoundException("There is no products with name: " + name))
                    .stream().map(mapper::map).collect(Collectors.toList());
        }

        return Optional.ofNullable(repository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ProductNotFoundException("There is no products"))
                .stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public ProductAdapterEntity findByProductId(UUID id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product " + id.toString() + " not found")));
    }

    @Override
    public ProductAdapterEntity saveProduct(ProductAdapterEntity product) {
        return mapper.map(repository.save(mapper.map(product)));
    }
}
