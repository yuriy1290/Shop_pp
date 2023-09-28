package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "deliveryView")
public class DeliveryView {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank(message = "Введите название вида")
        private String name;

        @OneToOne(mappedBy = "deliveryView")
        private Delivery delivery;

    public DeliveryView() {
    }

    public DeliveryView(Long id, String name, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.delivery = delivery;
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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
