package jims.test.project.mongo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jims.test.project.mongo.dataobjects.Person;
import jims.test.project.mongo.repos.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository pRepo;

    @GetMapping("testPopulate")
    public void testPpopulate() {
        Person p1 = new Person();
        p1.setName("Tom");
        pRepo.insert(p1);
    }

    @GetMapping("all")
    public Collection<Person> getAll() {
        return pRepo.findAll();
    }
    
}
