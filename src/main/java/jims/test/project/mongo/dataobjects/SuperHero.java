package jims.test.project.mongo.dataobjects;

import org.springframework.data.mongodb.core.mapping.Document;

// this defines 2 things: the collection that the object is stored in AND the rtype in dbreferences (sessential of inheritance)
@Document(collection="person")
public class SuperHero extends Person {
    
    private String power;
    private Person alterEgo;

    public String getPower() {return power;}
    public void setPower(String power) {this.power = power;}
}
