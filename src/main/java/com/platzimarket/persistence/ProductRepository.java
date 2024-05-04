package com.platzimarket.persistence;

import com.platzimarket.domain.ProductDTO;
import com.platzimarket.domain.repository.IProductRepository;
import com.platzimarket.persistence.crud.ProductCRUDRepository;
import com.platzimarket.persistence.entity.Product;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepository implements IProductRepository {

    private final ProductCRUDRepository productCRUDRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductRepository(ProductCRUDRepository productCRUDRepository, ProductMapper productMapper) {
        this.productCRUDRepository = productCRUDRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAll(){
        List<Product> products = (List<Product>) productCRUDRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int idCategory) {
        List<Product> products = productCRUDRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(productMapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCRUDRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(productMapper::toProducts);
    }
    @Override
    public Optional<ProductDTO> getProduct(int idProduct) {
        return  productCRUDRepository.findById(idProduct).map(productMapper::toProductDTO);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product product1= productCRUDRepository.save(productMapper.toProduct(product));
        return productMapper.toProductDTO(product1);
    }

    @Override
    public void deleteProduct(int idProduct) {
        productCRUDRepository.deleteById(idProduct);
    }
}
