package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCRUDRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);

}
