package jims.test.project.mongo.controllers;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoExpression;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jims.test.project.mongo.dataobjects.Company;

@RestController
@RequestMapping("/planb")
public class PlanBController {
    
    @Autowired
    private MongoTemplate mt;

    @GetMapping("all")
    public List<Company> getAllCompanies() {
        
        Query q = new Query();
        q.fields().include("employee", "boss");
        return mt.find(q, Company.class);
    }
}
