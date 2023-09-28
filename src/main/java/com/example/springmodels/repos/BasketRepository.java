package com.example.springmodels.repos;

import com.example.springmodels.models.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {
    Basket findByBasketSum(String basketSum);
}
