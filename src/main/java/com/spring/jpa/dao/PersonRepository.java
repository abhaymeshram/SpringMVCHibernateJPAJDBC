package com.spring.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
 
}
