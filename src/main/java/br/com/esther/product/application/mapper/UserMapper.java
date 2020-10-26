package br.com.esther.product.application.mapper;

import br.com.esther.product.adapters.datastore.ports.user.UserAdapterEntity;
import br.com.esther.product.domain.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserMapper {

    User map(UserAdapterEntity userAdapterEntity);

    UserAdapterEntity map(User user);

}

