package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.User.UserResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRestMapper {

    default User toUser(UserCreateRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .rolId(new UserRol(request.getRolId()))
                .active(true)
                .build();
    }

    default User toUser(UserPutRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .rolId(new UserRol(request.getRolId()))
                .active(request.getActive())
                .build();
    }

    default Page<UserResponse> toUserResponse(Page<User> users){
        return users.map(this::toUserResponse);
    }

    UserResponse toUserResponse(User response);

    List<UserResponse> toUserResponseList(List<User> userList);
}
