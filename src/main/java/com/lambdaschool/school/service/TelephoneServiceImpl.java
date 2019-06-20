package com.lambdaschool.school.service;

import com.lambdaschool.school.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService
{
    @Autowired
    private TelephoneRepository instructrepos;
}
