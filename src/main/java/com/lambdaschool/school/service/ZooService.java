package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Zoo;
import com.lambdaschool.school.view.CountAnimalInZoo;

import java.util.ArrayList;

public interface ZooService{
    ArrayList<Zoo> findAll();

    ArrayList<CountAnimalInZoo> getCountAnimalInZoo();

    void delete(long id);
}
