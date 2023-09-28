package com.example.springmodels.repos;

import com.example.springmodels.models.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    Delivery findByAdress(String adress);
}
