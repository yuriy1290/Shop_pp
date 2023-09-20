package com.example.springmodels.repos;

import com.example.springmodels.models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Genre findByGenreName(String genreName);

}
