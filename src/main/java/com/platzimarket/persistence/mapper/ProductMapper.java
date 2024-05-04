package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.ProductDTO;
import com.platzimarket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "idProduct"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "purchasePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "quantityStock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProducts(List<Product> products);
    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDTO productDTO);

}
