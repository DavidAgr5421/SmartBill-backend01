package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.RolPrivilegesCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.RolPrivilegesPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.RolPrivilegesResponse;

@Mapper(componentModel = "spring")
public interface RolPrivilegesRestMapper {

    RolPrivileges toRolPrivileges(RolPrivilegesCreateRequest request);

    RolPrivileges toRolPrivilegesPut(RolPrivilegesPutRequest request);

    RolPrivilegesResponse toRolPrivilegesResponse(RolPrivileges domain);
}
