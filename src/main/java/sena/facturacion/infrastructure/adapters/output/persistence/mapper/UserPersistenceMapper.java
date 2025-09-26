package sena.facturacion.infrastructure.adapters.output.persistence.mapper;


import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

    List<User> toUserList(List<UserEntity> entityList);

    default Page<User> toDomainPage(Page<UserEntity> entityPage){
        return entityPage.map(this::toUser);
    }
}
