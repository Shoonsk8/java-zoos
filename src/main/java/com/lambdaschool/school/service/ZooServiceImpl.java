package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Zoo;
import com.lambdaschool.school.repository.ZooRepository;
import com.lambdaschool.school.view.CountAnimalInZoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public ArrayList<CountAnimalInZoo> getCountAnimalInZoo()
    {
        return zoorepos.getCountAnimalInZoo();
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (zoorepos.findById(id).isPresent())
        {
            zoorepos.deleteAnimalFromAnimalZoo(id);
            zoorepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
}
