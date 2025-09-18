package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.UserResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {

    default User toUser(UserCreateRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .rolId(new UserRol(request.getRolId()))
                .build();
    }

    UserResponse toUserResponse(User response);

    List<UserResponse> toUserResponseList(List<User> userList);
}
