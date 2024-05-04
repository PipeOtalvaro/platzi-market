package com.platzimarket.domain.service;

import com.platzimarket.domain.ProductDTO;
import com.platzimarket.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository productRepository;
    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll(){
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }

    public Optional<List<ProductDTO>> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }

    public ProductDTO save(ProductDTO productDTO){
        return productRepository.save(productDTO);
    }

    public boolean delete(int idProduct){
        return getProduct(idProduct).map(productDTO -> {
            productRepository.deleteProduct(idProduct);
            return true;
        }).orElse(false);
    }
}
