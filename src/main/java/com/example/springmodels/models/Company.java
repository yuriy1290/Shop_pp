package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "company")
public class Company {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank(message = "Введите название ")
        private String name;
        @NotBlank(message = "Введите ИНН")
        private String INN;
        @NotBlank(message = "Введите ОГРН")
        private String OGRN;
        @NotBlank(message = "Введите физ.адрес")
        private String fizAdress;
        @NotBlank(message = "Введите юр.адрес")
        private String urAdress;
        @NotBlank(message = "Прикрепите логотип")
        private String Logo;

    @OneToMany(mappedBy = "company")
    private List<User> users;
    @OneToMany(mappedBy = "company")
    private List<Contacts> contacts;

    public Company() {
    }

    public Company(Long id, String name, String INN, String OGRN, String fizAdress, String urAdress, String logo) {
        this.id = id;
        this.name = name;
        this.INN = INN;
        this.OGRN = OGRN;
        this.fizAdress = fizAdress;
        this.urAdress = urAdress;
        this.Logo = logo;
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

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public String getFizAdress() {
        return fizAdress;
    }

    public void setFizAdress(String fizAdress) {
        this.fizAdress = fizAdress;
    }

    public String getUrAdress() {
        return urAdress;
    }

    public void setUrAdress(String urAdress) {
        this.urAdress = urAdress;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }


}
