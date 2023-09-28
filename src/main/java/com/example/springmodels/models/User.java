package com.example.springmodels.models;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long ID_User;
        private String username;
        private String password;


        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
        @CollectionTable(name = "User_role", joinColumns = @JoinColumn(name = "User_id"))
        @Enumerated(EnumType.STRING)
        private Set<Role> roles;

    @ManyToOne
    private Company company;

    @OneToOne(mappedBy = "user")
    private Basket basket;

    public User() {

    }

    public User(Long ID_User, String username, String password, Company company, Basket basket) {
        this.ID_User = ID_User;
        this.username = username;
        this.password = password;
        this.company = company;
        this.basket = basket;
    }

    public Long getID_User() {
        return ID_User;
    }

    public void setID_User(Long ID_User) {
        this.ID_User = ID_User;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
