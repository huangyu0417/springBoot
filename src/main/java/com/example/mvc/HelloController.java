package com.example.mvc;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

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
    public String getName(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        if (session.getAttribute("uuid") == null) {
            session.setAttribute("uuid", UUID.randomUUID().toString());
        }
        log.info(session.toString());
        while (attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            log.info("session => " + s + session.getAttribute(s));
        }
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
