package com.example.springmodels.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "paymentView")
public class PaymentView {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank(message = "Введите название вида")
        private String name;

        @OneToOne(mappedBy = "paymentView")
        private Payment payment;

    public PaymentView() {
    }

    public PaymentView(Long id, String name, Payment payment) {
        this.id = id;
        this.name = name;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
