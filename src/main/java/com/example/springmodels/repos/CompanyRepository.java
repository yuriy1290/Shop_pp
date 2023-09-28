package com.example.springmodels.repos;

import com.example.springmodels.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByName(String name);
}
