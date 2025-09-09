package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ProductEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class BillSpecification {

    public static Specification<BillEntity> withFilters(BillSearchRequest request){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getUserId() != null){
                Join<BillEntity, UserEntity> userJoin = root.join("userId");
                predicates.add(criteriaBuilder.equal(userJoin.get("id"), request.getUserId()));
            }

            if(request.getClientId() != null){
                Join<BillEntity, ClientEntity> clientJoin = root.join("clientId");
                predicates.add(criteriaBuilder.equal(clientJoin.get("id"), request.getClientId()));
            }

            if(request.getProductName() != null && !request.getProductName().isEmpty()){
                Join<Object, Object> detailsJoin = root.join("billDetails");
                Join<Object, Object> productJoin = detailsJoin.join("product");
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(productJoin.get("name")), "%" + request.getProductName() + "%"));
            }

            if(request.getStartTotal() != null && request.getEndTotal() != null){
                predicates.add(criteriaBuilder.between(root.get("total"),request.getStartTotal(), request.getEndTotal()));
            }

            if(request.getFromDate() != null && request.getToDate() != null){
                predicates.add(criteriaBuilder.between(root.get("creationDate"),request.getFromDate(), request.getToDate()));
            }

            if(request.getPaymentMethod() != null && !request.getPaymentMethod().isEmpty()){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("paymentMethod")), "%" + request.getPaymentMethod().toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new  Predicate[0]));
        };
    }
}
