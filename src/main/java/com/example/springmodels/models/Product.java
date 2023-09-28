package com.example.springmodels.models;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Введите название")
    private String name;

    @NotBlank(message = "Введите информацию")
    private String information;

    @NotBlank(message = "Вставьте фото")
    private String photo;

    @NotBlank(message = "Введите цену")
    private float price;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "productView_id")
    private ProductView productView;



    @OneToMany(mappedBy = "product")
    private List<BasketProduct> basketProducts;
    public Product() {
    }

    public Product(Long id, String name, String information, String photo, float price, ProductView productView) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.photo = photo;
        this.price = price;
        this.productView = productView;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductView getProductView() {
        return productView;
    }

    public void setProductView(ProductView productView) {
        this.productView = productView;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
