package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.UserResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {

    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User response);

    List<UserResponse> toUserResponseList(List<User> userList);
}
