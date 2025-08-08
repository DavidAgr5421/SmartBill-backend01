package sena.facturacion.infrastructure.adapters.input.rest.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillDetailResponse;

@Mapper(componentModel = "spring")
public interface BillDetailRestMapper {

    BillDetailResponse toDetailResponse(BillDetail domain);

    @Mapping(target = "id", ignore = true)
    BillDetail toDetail(BillDetailCreateRequest request);

    default Page<BillDetailResponse> toDetailResponsePage(Page<BillDetail> domain) {
        return domain.map(this::toDetailResponse);
    }

    default Bill mapBill(Long billId) {
        if (billId == null) return null;
        return new Bill(billId);
    }

    default Long mapBillId(Bill bill) {
        if (bill == null) return null;
        return bill.getId();
    }

    default Product mapProduct(Long productId) {
        if (productId == null) return null;
        return new Product(productId);
    }

    default Long mapProductId(Product product) {
        if (product == null) return null;
        return product.getId();
    }

    BillDetail putToDetail( BillDetailPutRequest detailPutRequest);
}
