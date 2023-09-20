package com.example.springmodels.repos;

import com.example.springmodels.models.PublisherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublisherDetailsRepository extends CrudRepository<PublisherDetails, Long> {

    PublisherDetails findByInformation(String information);

}
