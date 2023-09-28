package com.example.springmodels.repos;

import com.example.springmodels.models.DeliveryView;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryViewRepository extends CrudRepository<DeliveryView, Long> {
    DeliveryView findByName(String name);
}
