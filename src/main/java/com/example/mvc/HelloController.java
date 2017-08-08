package com.example.mvc;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 19:02
 */
@RestController
@RequestMapping("/springBoot")
public class HelloController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/name")
    public String getName() {
        personRepository.save(new Person("hy",23,"hz"));
        System.out.println(personRepository.findByName("hy"));
        Person p1 = new Person("p1",23,"beijing");
        Person p2 = new Person("p2",23,"beijing");
        Person p3 = new Person("p3",23,"beijing");
        Person p4 = new Person("p4",23,"beijing");
        Person p5 = new Person("p5",23,"beijing");
        List<Person> list = Arrays.asList(p1,p2,p3,p4,p5);

        personRepository.save(list);

        System.out.println(personRepository.findAll().size());
        personRepository.delete(p2);
        System.out.println(personRepository.findAll().size());
        System.out.println(personRepository.findByName("p4"));
        return "Hello";
    }

}
