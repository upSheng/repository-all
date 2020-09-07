package com.web.util;

import com.mongodb.client.MongoClients;
import com.web.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/19 11:07
 */
public class MongdbTest {

    private  MongoOperations mongoOps ;
    @Before
    public void before(){
        mongoOps = new MongoTemplate(MongoClients.create(), "myDatabase");
    }


    @Test
    public void createTest(){

        Person p = new Person("Joe", 34);
        p.setId("222222");

        // Insert is used to initially store the object into the database.
        mongoOps.insert(p);
    }

    @Test
    public void  selectTest(){
        List<Person> all = mongoOps.findAll(Person.class);
        System.out.println(all);
    }
}
