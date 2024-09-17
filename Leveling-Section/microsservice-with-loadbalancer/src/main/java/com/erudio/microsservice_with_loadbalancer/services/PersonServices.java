package com.erudio.microsservice_with_loadbalancer.services;

import com.erudio.microsservice_with_loadbalancer.exception.handler.ResourceNotFoundException;
import com.erudio.microsservice_with_loadbalancer.models.Person;
import com.erudio.microsservice_with_loadbalancer.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    private PersonRepository repository;


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        log.info("Finding all people");

        return repository.findAll();
    }


    public Person findById(Long id) {
        log.info("Finding a Person");;
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found with this id"));
    }

    public Person createPerson(Person person) {
        return repository.save(person);
    }


    public Person updatePerson(Person person) {
        var entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found with this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void deletePerson(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found with this id"));
        repository.delete(entity);
    }
}
