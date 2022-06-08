package jims.test.project.mongo.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import jims.test.project.mongo.dataobjects.Person;
import jims.test.project.mongo.dataobjects.SuperHero;

public interface PersonRepository extends MongoRepository<Person, String> {

//    List<NamedThing> findAll();

    public interface NamedThing {
        String getName();
    }
}
