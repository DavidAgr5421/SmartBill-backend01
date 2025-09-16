package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ReportEntity;

import java.util.ArrayList;
import java.util.List;

public class ReportSpecification {

    public static Specification<ReportEntity> withFilters(ReportSearchRequest request){
        return (root,query,criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getUserId() != null){
                predicates.add(criteriaBuilder.equal(root.get("userId"),request.getUserId()));
            }
            if(request.getTotalSales() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalSales"), request.getTotalSales()));
            }
            if(request.getMonthSales() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("monthSales"),request.getMonthSales()));
            }
            if(request.getProductsOnStock() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productOnStock")), "%"+request.getProductsOnStock().toLowerCase()+"%"));
            }
            if(request.getProductOnLowStock() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productOnLowStock")),"%"+request.getProductOnLowStock().toLowerCase()+"%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
