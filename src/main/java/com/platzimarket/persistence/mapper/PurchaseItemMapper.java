package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.PurchaseItemDTO;
import com.platzimarket.persistence.entity.PurchasesProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "id"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItemDTO toPurchaseItem(PurchasesProduct product);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true)
    })
    PurchasesProduct toPurchaseItem(PurchaseItemDTO product);
}
