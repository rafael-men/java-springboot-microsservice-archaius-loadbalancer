package com.erudio.microsservice_with_loadbalancer.controllers;


import com.erudio.microsservice_with_loadbalancer.models.Person;
import com.erudio.microsservice_with_loadbalancer.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value = "id") String id) {
        return service.findById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll () {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create (@RequestBody Person person) {
        return service.createPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update (@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete (@PathVariable(value = "id") String id) {

    }

}
