package jims.test.project.mongo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jims.test.project.mongo.dataobjects.Company;
import jims.test.project.mongo.dataobjects.Person;
import jims.test.project.mongo.repos.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyRepository cRepo;

    /**
     * This returns employees == null (as its a reference to a collection(==bunch of references))
     * Returns boss inline though. Sure this didn't happen earlier...
     * @return
     */
    @GetMapping("all")
    public Collection<Company> getAll() {
        return cRepo.findAll();
    }

    /**
     *  You can be more specific pulling a specific instance:
     * GET http://localhost:8080/company/get?id=Widgets%20corp
     * but still employees is empty
     */
    @RequestMapping(value = "get{id}", method = RequestMethod.GET)
    public Optional<Company> getCompany(String id) {
        return cRepo.findById(id);
    }

    /**
     * you can pull employees for a given Company:
     * http://localhost:8080/company/employees?id=Widgets%20corp - but you don't get the subclasses!
     */
    @RequestMapping(value = "employees{id}", method = RequestMethod.GET)
    public Collection<Person> getEmployees(String id) {
        return cRepo.findById(id).map(Company::getEmployees).get();
    }
}
