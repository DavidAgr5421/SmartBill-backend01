package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

import java.util.ArrayList;
import java.util.List;

public class BillSpecification {

    public static Specification<BillEntity> withFilters(BillSearchRequest request){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getBillId() != null){
                predicates.add(criteriaBuilder.equal(root.get("id"),request.getBillId()));
            }

            if(request.getUserId() != null){
                predicates.add(criteriaBuilder.equal(root.get("userId").get("id"),request.getUserId()));
            }

            if(request.getClientId() != null){
                predicates.add(criteriaBuilder.equal(root.get("clientId").get("id"), request.getClientId()));
            }

            if(request.getProductName() != null && !request.getProductName().isEmpty()){
                Join<BillEntity, Object> detailsJoin = root.join("billDetails");
                Join<Object, Object> productJoin = detailsJoin.join("productId");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(productJoin.get("name")), "%" + request.getProductName() + "%"));
            }

            if(request.getStartTotal() != null && request.getEndTotal() != null){
                predicates.add(criteriaBuilder.between(root.get("total"),request.getStartTotal(), request.getEndTotal()));
            }

            if(request.getFromDate() != null && request.getToDate() != null){
                predicates.add(criteriaBuilder.between(root.get("creationDate"),request.getFromDate(), request.getToDate()));
            }

            if(request.getPaymentMethod() != null && !request.getPaymentMethod().isEmpty()){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("paymentMethod")), "%" + request.getPaymentMethod().toUpperCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new  Predicate[0]));
        };
    }
}
