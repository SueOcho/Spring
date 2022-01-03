package com.springdata.data.service;

import com.springdata.data.model.Product;
import com.springdata.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService<Product,Integer>{



    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Integer id) {

        return productRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> findAll() {
        return Optional.of(productRepository.findAll());
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(product-> {productRepository.delete(product);
        return true;}).orElse( false) ;
    }
}
