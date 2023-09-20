package com.example.springmodels.repos;

import com.example.springmodels.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{

    Author findBySurname(String surname);

}
