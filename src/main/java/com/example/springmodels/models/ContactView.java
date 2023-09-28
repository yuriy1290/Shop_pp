package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "contactView")
public class ContactView {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NotBlank(message = "Введите название вида")
        private String name;

        @OneToOne(mappedBy = "contactView")
        private Contacts contacts;

    public ContactView() {
    }

    public ContactView(Long id, String name, Contacts contacts) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
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

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
