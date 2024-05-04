package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.PurchaseDTO;
import com.platzimarket.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "products", target = "items")
    })
    PurchaseDTO toPurchaseDTO(Purchase purchase);
    @InheritInverseConfiguration
    Purchase toPurchaseEntity(PurchaseDTO purchase);
    List<PurchaseDTO> toPurchases(List<Purchase> purchases);
}
