package sena.facturacion.infrastructure.adapters.input.rest.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserRolRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.UserRolResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRolRestMapper {
    
    UserRol toUserRol(UserRolRequest request);

    UserRolResponse toUserRolResponse(UserRol response);

    List<UserRolResponse> toUserRolResponseList(List<UserRol> response);
}
