package jims.test.project.mongo.dataobjects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// not sure we need @Document
@Document(collection="person")
public class Person {
    
    // this will get populated by _id value in DB
    @Id
    private String id;

    private String name;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
