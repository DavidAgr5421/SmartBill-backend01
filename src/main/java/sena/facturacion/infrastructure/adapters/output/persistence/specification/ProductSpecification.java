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
            if (request.getAmount() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("amount"), request.getAmount()));
            }
            if (request.getStartDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), request.getStartDate()));
            }
            if (request.getEndDate() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), request.getEndDate()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
