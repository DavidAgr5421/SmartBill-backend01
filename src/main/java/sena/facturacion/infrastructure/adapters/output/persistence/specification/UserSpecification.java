package sena.facturacion.infrastructure.adapters.output.persistence.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<UserEntity> withFilters(UserSearchRequest request){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getName() != null ){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+request.getName().toLowerCase()+"%"));
            }
            if(request.getEmail() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")),"%"+request.getEmail().toLowerCase()+"%"));
            }
            if(request.getRolId() != null){
                predicates.add(criteriaBuilder.equal(root.get("rolId").get("id"),request.getRolId()));
            }
            if(request.getActive() != null){
                predicates.add(criteriaBuilder.equal(root.get("active"),request.getActive()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
