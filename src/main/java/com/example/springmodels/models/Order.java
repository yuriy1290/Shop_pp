package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;
    @OneToOne(mappedBy = "order")
    private Feedback feedback;

    public Order() {
    }

    public Order(Long id, Payment payment, Delivery delivery, Basket basket, Feedback feedback) {
        this.id = id;
        this.payment = payment;
        this.delivery = delivery;
        this.basket = basket;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
