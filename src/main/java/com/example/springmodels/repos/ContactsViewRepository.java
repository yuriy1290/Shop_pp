package com.example.springmodels.repos;

import com.example.springmodels.models.ContactView;
import org.springframework.data.repository.CrudRepository;

public interface ContactsViewRepository extends CrudRepository<ContactView, Long> {
    ContactView findByName(String name);
}
