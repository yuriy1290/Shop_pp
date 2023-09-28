package com.example.springmodels.repos;

import com.example.springmodels.models.Contacts;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<Contacts, Long> {
    Contacts findByContact(String contact);
}
