package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ClientSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;

import java.util.ArrayList;
import java.util.List;

public class ClientSpecification {

    public static Specification<ClientEntity> withFilters(ClientSearchRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getId() != null){
                predicates.add(criteriaBuilder.equal(root.get("id"),request.getId()));
            }
            if (request.getName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+ request.getName().toLowerCase() +"%"));
            }
            if(request.getAddress() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")),"%"+request.getAddress().toLowerCase()+"%"));
            }
            if(request.getContact() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("contact")),"%"+request.getContact()+"%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
