package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "Итог:")
    private float paymentSum;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_view_id")
    private PaymentView paymentView;
    @OneToOne(mappedBy = "payment")
    private Order order;

    public Payment() {
    }

    public Payment(Long id, float paymentSum, PaymentView paymentView, Order order) {
        this.id = id;
        this.paymentSum = paymentSum;
        this.paymentView = paymentView;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(float paymentSum) {
        this.paymentSum = paymentSum;
    }

    public PaymentView getPaymentView() {
        return paymentView;
    }

    public void setPaymentView(PaymentView paymentView) {
        this.paymentView = paymentView;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
