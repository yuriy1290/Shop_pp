package com.example.springmodels.repos;

import com.example.springmodels.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findByTitleContains(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByTitleIsContaining(String title);
    List<Book> findByTitleEquals(String title);

}
