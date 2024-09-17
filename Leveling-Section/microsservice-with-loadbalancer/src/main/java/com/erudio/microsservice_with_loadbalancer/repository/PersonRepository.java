package com.erudio.microsservice_with_loadbalancer.repository;

import com.erudio.microsservice_with_loadbalancer.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
