package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Animal;
import com.lambdaschool.school.model.Zoo;
import com.lambdaschool.school.service.AnimalService;
import com.lambdaschool.school.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{
    @Autowired
    private ZooService animalService;

    @GetMapping(value = "/animals", produces = {"application/json"})
    public ResponseEntity<?> listAllAnimals()
    {
        ArrayList<Zoo> myAnimals = animalService.findAll();
        return new ResponseEntity<>(myAnimals, HttpStatus.OK);
    }

    @GetMapping(value = "/animalcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInAnimals()
    {
        return new ResponseEntity<>(animalService.getCountAnimalInZoo(), HttpStatus.OK);
    }

    @DeleteMapping("/animals/{animalid}")
    public ResponseEntity<?> deleteAnimalById(@PathVariable long animalid)
    {
        animalService.delete(animalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

//HttpStatus
//    There is a many to many relationship between zoos and animals. A zoo may have many animal types and an animal type may be at many zoos.
//
//        Use the file data.sql to seed your database.
//
//        Expose the following end points
//
//        GET /zoos/zoos - returns all zoos with their phone numbers and animals
//
//        GET /animals/count - that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this.
//
//        For the PUT and POST you can assume you are sent all the data with the appropriate ids included
//
//        PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
//        Update the Zoo and associated phone number. This does NOT address the Zoo Animal combinations! That would be a separate end point
//
//        POST /admin/zoos - add the zoo
//        Add the Zoo and associated phone number(s). This does NOT address the Zoo Animal combinations! That would be a separate end point.
//        In the header return as the location of the newly created zoo POST /admin/zoos/{id}
//
//        DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
//        This should delete the Zoo, associated telephone numbers, and zoo animals combinations associated with this zoo.
//
//        Stretch Goals
//
//        Expose the end point GET /zoos/zoos/(id) - returns the zoo identified by id with its phone numbers and animals
//        In the PUT /admin/zoos endpoint, return in the header a link to the zoo created with the endpoint /zoos/zoos/{id}
//        Expose the end point DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids.
//        Hint: @PathVariable("zooid") long zooid, @PathVariable("animalid") long animalid
//        Expose the end point POST /admin/zoos/{zooid}/animals/{animalid} - adds the zoo animal combination based off of ids.
//        Hint: @PathVariable("zooid") long zooid, @PathVariable("animalid") long animalid
//        Log to the console each time a record in the database is changed.
