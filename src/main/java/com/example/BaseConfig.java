package com.example;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 19:00
 */
@EnableJpaRepositories
public class BaseConfig {

}
