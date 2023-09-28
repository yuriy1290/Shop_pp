package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Введите время")
    private String time;
    @NotBlank(message = "Введите адрес")
    private String adress;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryView_id")
    private DeliveryView deliveryView;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    public Delivery() {
    }

    public Delivery(Long id, String time, String adress, DeliveryView deliveryView, Order order) {
        this.id = id;
        this.time = time;
        this.adress = adress;
        this.deliveryView = deliveryView;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public DeliveryView getDeliveryView() {
        return deliveryView;
    }

    public void setDeliveryView(DeliveryView deliveryView) {
        this.deliveryView = deliveryView;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
