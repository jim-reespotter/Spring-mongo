package jims.test.project.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import jims.test.project.mongo.dataobjects.Person;

public interface PersonRepository extends MongoRepository<Person, String> {}
