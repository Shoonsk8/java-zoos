package com.lambdaschool.school.repository;

import com.lambdaschool.school.model.Animal;
import com.lambdaschool.school.model.Zoo;
import com.lambdaschool.school.view.CountAnimalInZoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    ArrayList<Zoo> findAnimalsByZoonameEquals(String name);

    @Modifying
    @Query(value = "DELETE FROM studanimals WHERE animalid = :animalid", nativeQuery = true)
    void deleteAnimalFromAnimalZoo(long animalid);

    @Query(value = "SELECT s.animalid, animalname, count(studid) as countstudents FROM studanimals s INNER JOIN animal c on s.animalid=c.animalid GROUP BY s.animalid, animalname", nativeQuery = true)
    ArrayList<CountAnimalInZoo> getCountAnimalInZoo();
}

