package com.certus.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Personaje;

@Repository
public interface IPersonaje extends CrudRepository<Personaje, Integer> {

}
