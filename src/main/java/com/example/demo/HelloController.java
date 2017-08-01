package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/1 8:31
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String say() {
        return "Hello world!";
    }
}
