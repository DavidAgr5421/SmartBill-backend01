package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ProductSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<ProductEntity> withFilters(ProductSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getName() != null && !request.getName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + request.getName().toLowerCase() + "%"));
            }
            if (request.getReferenceNo() != null && !request.getReferenceNo().isEmpty()) {
                predicates.add(cb.like(cb.upper(root.get("referenceNo")), "%" + request.getReferenceNo().toUpperCase() + "%"));
            }

            if(request.getStartAmount() != null && request.getEndAmount() != null){
                predicates.add(cb.between(root.get("amount"), request.getStartAmount(), request.getEndAmount()));
            }

            if (request.getStartDate() != null && request.getEndDate() != null) {
                predicates.add(cb.between(root.get("createdAt"),request.getStartDate(),request.getEndDate()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
