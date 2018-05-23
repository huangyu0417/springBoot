package com.example.mvc;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 19:02
 */
@Slf4j
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

        personRepository.saveAll(list);

        System.out.println(personRepository.findAll().size());
        personRepository.delete(p2);
        System.out.println(personRepository.findAll().size());
        System.out.println(personRepository.findByName("p4"));
        return "Hello";
    }

    @RequestMapping("/default")
    public Person defaultPerson() {
        log.debug("/default");
        return new Person("黄宇",24,"HangZhou");
    }

    /*
     * 和前台进行json对象转换
     * 条件：前台使用post方法，设置Content-Type为"application/json"
     *      后台使用@RequestBody，当需要传多个对象时，使用包装对象。
     *
     *
     */
    @PostMapping("/binding")
    public  Object dataBinding(@RequestHeader("Content-Type") String conType, @RequestBody Param param) {
        log.info("Content-Type => {}", conType);
        log.info(param.toString());
        return param;
    }

    @RequestMapping("/bindingString")
    public void stringBinding(String userName, Integer id, String address) {
        log.info("姓名: {}， id： {}， address: {}", userName, id, address);
    }

    @Data
    @NoArgsConstructor
    private static class Param {
        Person person;

        String[] roles;
    }

}
