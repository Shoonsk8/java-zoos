package com.lambdaschool.school.repository;

import com.lambdaschool.school.model.Telephone;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface TelephoneRepository extends CrudRepository<Telephone, Long>
{
    ArrayList<Telephone> findTelephonesByInstructnameEquals (String name);
}
