package com.example.springmodels.repos;

import com.example.springmodels.models.AuthorDetails;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDetailsRepository extends CrudRepository<AuthorDetails, Long>{

    AuthorDetails findByBiography(String biography);

}
