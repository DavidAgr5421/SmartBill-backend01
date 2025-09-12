package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Configuration;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ConfigurationEntity;

@Mapper(componentModel = "spring")
public interface ConfigurationPersistenceMapper {

    ConfigurationEntity toEntity(Configuration domain);
    Configuration toDomain(ConfigurationEntity entity);

    default Page<Configuration> toDomainPage(Page<ConfigurationEntity> entities){
        return entities.map(this::toDomain);
    }
}
