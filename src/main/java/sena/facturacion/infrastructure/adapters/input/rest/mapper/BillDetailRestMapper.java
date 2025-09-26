package sena.facturacion.infrastructure.adapters.input.rest.mapper;


import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Bill.BillDetailResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillDetailRestMapper {

    default BillDetailResponse toDetailResponse(BillDetail domain){
        return BillDetailResponse.builder()
                .billId(domain.getBillId().getId())
                .productId(domain.getProductId().getId())
                .id(domain.getId())
                .amount(domain.getAmount())
                .observation(domain.getObservation())
                .subTotal(domain.getSubTotal())
                .build();
    };

    default BillDetail putToDetail(BillDetailPutRequest request){
        return BillDetail.builder()
                .productId(new Product(request.getProductId()))
                .amount(request.getAmount())
                .subTotal(request.getSubTotal())
                .observation(request.getObservation())
                .build();
    };

    default BillDetail toDetail(BillDetailCreateRequest request){
        return BillDetail.builder()
                .billId(new Bill(request.getBillId()))
                .productId(new Product(request.getProductId()))
                .amount(request.getAmount())
                .subTotal(request.getSubTotal())
                .observation(request.getObservation())
                .build();
    }

    default Page<BillDetailResponse> toDetailResponsePage(Page<BillDetail> domain) {
        return domain.map(this::toDetailResponse);
    }

    default List<BillDetailResponse> toDetailResponseList(List<BillDetail> domain){
        return domain.stream().map(this::toDetailResponse).toList();
    }
}
