package com.example.springmodels.repos;

import com.example.springmodels.models.PaymentView;
import org.springframework.data.repository.CrudRepository;

public interface PaymentViewRepository extends CrudRepository<PaymentView, Long> {
    PaymentView findByName(String name);
}
