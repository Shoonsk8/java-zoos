package com.lambdaschool.school.service;

import com.lambdaschool.school.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService{


    @Autowired
    private AnimalRepository animalrepos;
}
