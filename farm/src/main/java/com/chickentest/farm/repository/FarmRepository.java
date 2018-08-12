package com.chickentest.farm.repository;

import com.chickentest.farm.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FarmRepository extends JpaRepository<Farm, Long> {
}
