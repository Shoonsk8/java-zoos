package com.lambdaschool.school.repository;

import com.lambdaschool.school.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    ArrayList<Animal> findAnimalsByStudnameEquals(String name);
}
