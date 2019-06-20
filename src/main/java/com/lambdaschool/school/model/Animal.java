package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studid;

    private String studname;

    @ManyToMany
    @JoinTable(name = "studanimals",
               joinColumns = {@JoinColumn(name = "studid")},
               inverseJoinColumns = {@JoinColumn(name = "animalid")})
    @JsonIgnoreProperties("animals")
    private List<Animal> animals = new ArrayList<>();

    public Animal()
    {
    }

    public Animal(String studname)
    {
        this.studname = studname;
    }

    public long getStudid()
    {
        return studid;
    }

    public void setStudid(long studid)
    {
        this.studid = studid;
    }

    public String getStudname()
    {
        return studname;
    }

    public void setStudname(String studname)
    {
        this.studname = studname;
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }
}
