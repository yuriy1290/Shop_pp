package com.example.springmodels.repos;

import com.example.springmodels.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Payment findByPaymentSum(String paymentSum);
}
