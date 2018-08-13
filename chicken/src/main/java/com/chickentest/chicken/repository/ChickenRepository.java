package com.chickentest.chicken.repository;

import com.chickentest.chicken.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ChickenRepository extends JpaRepository<Chicken, Long> {

}
