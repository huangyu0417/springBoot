package com.example.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 18:26
 */

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 20,unique = true,nullable = false)
    private String name;

    private int age;

    private String address;

    @Transient
    private List<String> pages;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
