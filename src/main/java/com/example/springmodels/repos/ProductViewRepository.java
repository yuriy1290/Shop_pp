package com.example.springmodels.repos;

import com.example.springmodels.models.ProductView;
import org.springframework.data.repository.CrudRepository;

public interface ProductViewRepository extends CrudRepository<ProductView, Long> {
    ProductView findByName(String name);
}
