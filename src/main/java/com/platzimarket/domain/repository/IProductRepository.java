package com.platzimarket.domain.repository;

import com.platzimarket.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int idCategory);
    Optional<List<ProductDTO>> getScarceProducts(int quantity);

    Optional<ProductDTO> getProduct(int idProduct);

    ProductDTO save(ProductDTO product);

    void deleteProduct(int idProduct);
}
