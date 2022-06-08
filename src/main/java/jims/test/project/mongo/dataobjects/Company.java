package jims.test.project.mongo.dataobjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Company {
    
    // this works, the name becomes the key (rather than a generated string)
    // so probably a really bad idea to change it
    @Id
    private String name;

    // DBRef adds ref instead of including the object inline
    @DBRef
    private Person boss;
    @DBRef
    private List<Person> employees = new ArrayList<Person>();

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Person getBoss() {return boss;}
    public void setBoss(Person boss) {this.boss = boss;}

    public List<Person> getEmployees() {return employees;}
    // shouldn't need a setter - just add/remove members from colletion, right?
}
