package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class BillDetailSpecification {

    public static Specification<BillDetailEntity> withFilters(BillDetailSearchRequest request){
        return(root,query,criteriaBuilder)-> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getBillId() != null){
                predicates.add(criteriaBuilder.equal(root.get("billId").get("id"),request.getBillId()));
            }

            if(request.getProductId() != null){
                predicates.add(criteriaBuilder.equal(root.get("productId").get("id"), request.getProductId()));
            }

            if(request.getProductName() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productId").get("name")), "%"+request.getProductName()+"%"));
            }

            if(request.getStartSubTotal() != null && request.getEndSubTotal() != null){
                predicates.add(criteriaBuilder.between(root.get("subTotal"),request.getStartSubTotal(),request.getEndSubTotal()));
            }

            if(request.getStartAmount() != null && request.getEndAmount() != null){
                predicates.add(criteriaBuilder.between(root.get("amount"),request.getStartAmount(),request.getEndAmount()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
