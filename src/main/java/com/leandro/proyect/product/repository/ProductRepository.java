package com.leandro.proyect.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.leandro.proyect.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    boolean existsBySku(String sku);

}
