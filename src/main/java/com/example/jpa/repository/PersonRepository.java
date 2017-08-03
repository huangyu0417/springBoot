package com.example.jpa.repository;

import com.example.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/3 19:11
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByName(String name);
}
