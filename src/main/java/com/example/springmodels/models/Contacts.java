package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Введите имя")
    private String contact;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "contactView_id")
    private ContactView contactView;
    @ManyToOne
    private Company company;

    public Contacts(Long id, String contact, ContactView contactView, Company company) {
        this.id = id;
        this.contact = contact;
        this.contactView = contactView;
        this.company = company;
    }

    public Contacts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ContactView getContactView() {
        return contactView;
    }

    public void setContactView(ContactView contactView) {
        this.contactView = contactView;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
