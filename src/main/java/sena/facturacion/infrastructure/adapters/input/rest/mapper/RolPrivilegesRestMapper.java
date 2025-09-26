package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.RolPrivilegesCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.RolPrivilegesPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.User.RolPrivilegesResponse;

@Mapper(componentModel = "spring")
public interface RolPrivilegesRestMapper {

    RolPrivileges toRolPrivileges(RolPrivilegesCreateRequest request);

    RolPrivileges toRolPrivilegesPut(RolPrivilegesPutRequest request);

    RolPrivilegesResponse toRolPrivilegesResponse(RolPrivileges domain);
}
