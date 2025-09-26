package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Configuration;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Config.ConfigurationPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Config.ConfigurationResponse;

@Mapper(componentModel = "spring")
public interface ConfigurationRestMapper {

    ConfigurationResponse toResponse(Configuration domain);
    Configuration toDomain(ConfigurationPutRequest request);

    default Page<ConfigurationResponse> toResponsePage(Page<Configuration> domainPage){
        return domainPage.map(this::toResponse);
    }
}
