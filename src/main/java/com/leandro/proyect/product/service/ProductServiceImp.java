package com.leandro.proyect.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.proyect.product.entity.Product;
import com.leandro.proyect.product.repository.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product productDb = productOptional.orElseThrow();

            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setSku(product.getSku());
            productDb.setDescription(product.getDescription());

            return Optional.of(productRepository.save(productDb));
        }
        return productOptional;
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        productOptional.ifPresent(productDb -> {
            productRepository.delete(productDb);
        });

        return productOptional;
    }

    @Override
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);

    }

}
