package com.example.springmodels.repos;

import com.example.springmodels.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    Publisher findByName(String name);

}
