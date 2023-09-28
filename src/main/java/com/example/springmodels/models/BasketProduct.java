package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "basketProduct")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Basket basket;
    @ManyToOne
    private Product product;

    public BasketProduct() {
    }

    public BasketProduct(Long id, Basket basket, Product product) {
        this.id = id;
        this.basket = basket;
        this.product = product;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
