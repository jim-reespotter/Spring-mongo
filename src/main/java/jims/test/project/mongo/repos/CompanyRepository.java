package jims.test.project.mongo.repos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import jims.test.project.mongo.dataobjects.Company;

public interface CompanyRepository extends MongoRepository <Company,String>{  


}
