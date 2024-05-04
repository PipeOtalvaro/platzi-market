package com.platzimarket.web.controller;

import com.platzimarket.domain.ProductDTO;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAll(){

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int idProduct){
        return productService.getProduct(idProduct)
                .map(productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/getProductByCategory/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int idCategory){
        return productService.getByCategory(idCategory)
                .map(productDTOS ->
                    new ResponseEntity<>(productDTOS, HttpStatus.OK)
                ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idProduct){
        if(productService.delete(idProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}
