package com.example;

import com.example.jpa.entity.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 19:00
 */
@Configuration
@ComponentScan(basePackages = "com.example.jpa")
public class BaseConfig {
}
