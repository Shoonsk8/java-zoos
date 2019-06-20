package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonView(View.ZoosOnly.class)
    private long zooid;

//    @JsonView(View.ZoosOnly.class)
    private String zooname;

    @ManyToOne
    @JoinColumn(name = "instructid")
    @JsonIgnoreProperties("zoos")
//    @JsonView(View.ZoosOnly.class)
    private Telephone telephone;

    @ManyToMany(mappedBy = "zoos")
    @JsonIgnoreProperties("zoos")
    private List<Animal> animals = new ArrayList<>();

    public Zoo()
    {
    }

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }

    public Zoo(String zooname, Telephone telephone)
    {
        this.zooname = zooname;
        this.telephone = telephone;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public Telephone getTelephone()
    {
        return telephone;
    }

    public void setTelephone(Telephone telephone)
    {
        this.telephone = telephone;
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
