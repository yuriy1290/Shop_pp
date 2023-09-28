package com.example.springmodels.models;
import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
@Table(name = "productView")
public class ProductView {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank(message = "Введите название вида")
        private String name;

        @OneToOne(mappedBy = "productView")
        private Product product;

    public ProductView() {
    }

    public ProductView(Long id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
