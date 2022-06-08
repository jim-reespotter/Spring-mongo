package jims.test.project.mongo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jims.test.project.mongo.dataobjects.Company;
import jims.test.project.mongo.dataobjects.Person;
import jims.test.project.mongo.dataobjects.SuperHero;
import jims.test.project.mongo.repos.CompanyRepository;
import jims.test.project.mongo.repos.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository pRepo;

    @Autowired 
    private CompanyRepository cRepo;

    /**
     * call this via GET http://localhost:8080/person/testPopulate
     * - crstes a user (Tom). will create a new Tom for every call, each will have unique id value
     */
    @GetMapping("testPopulate")
    public void testPpopulate() {
        // normal person:
        Person p1 = new Person();
        p1.setName("Tom");
        pRepo.insert(p1);

        Person p2 = new Person();
        p2.setName("Elvis");
        pRepo.insert(p2);

        // superHeor:
        SuperHero s1 = new SuperHero();
        s1.setName("Bananaman");
        s1.setPower("he's yellow");
        pRepo.insert((Person)s1);

        // company:
        Company c = new Company();
        c.setName("Widgets corp");
        c.getEmployees().add(p2);
        c.getEmployees().add(s1);
        c.setBoss(p1);
        cRepo.insert(c);
    }

    /**
     * call this via GET http://localhost:8080/person/all
     * Things to note: 
     * - in DB there is a field _id - this doesn't appear in REST
     * - id is auto populated
     * - gets Persons and Superheros
     */ 
    @GetMapping("all")
    public Collection<Person> getAll() {
        return pRepo.findAll();
    }

    // doesn't work (java.lang.IllegalArgumentException: The given id must not be null!)
    // also, returns a collection of person rather than superhero.
    @GetMapping("allSuperheroes")
    public Collection<Person> getAllSuperheros() {
        return pRepo.findAll(Example.of(new SuperHero()));
    }

    // call GET http://localhost:8080/person/get?id=62a0a061cb43365a84319baa  (number is _id from database or all lookup)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Person> get(String id) {
        return pRepo.findById(id);
    }
}
