package com.example.mvc;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "Hello";
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
