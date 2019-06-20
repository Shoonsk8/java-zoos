package com.lambdaschool.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "telephone")
public class Telephone
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructid;

    private String instructname;

    @OneToMany(mappedBy = "telephone")
    @JsonIgnoreProperties("telephones")
    private List<Telephone> telephones = new ArrayList<>();

    public Telephone()
    {
    }

    public Telephone(String instructname)
    {
        this.instructname = instructname;
    }

    public long getInstructid()
    {
        return instructid;
    }

    public void setInstructid(long instructid)
    {
        this.instructid = instructid;
    }

    public String getInstructname()
    {
        return instructname;
    }

    public void setInstructname(String instructname)
    {
        this.instructname = instructname;
    }

    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }
}
