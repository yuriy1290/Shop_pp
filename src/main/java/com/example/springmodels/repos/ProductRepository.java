package com.example.springmodels.repos;

import com.example.springmodels.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
