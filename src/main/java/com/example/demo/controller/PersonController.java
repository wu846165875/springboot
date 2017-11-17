package com.example.demo.controller;

import com.example.demo.hibernate.repositoryinter.PersonRepository;
import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("personbyname")
    public Person test(String name){
        return personRepository.findByName(name);
    }
    @RequestMapping("personall")
    public List<Person> test2(){
         List<Person> person = personRepository.findAll();
         return  person;
    }
    @RequestMapping("withNameAndAddressQuery")
    public Person test3(String name,String address){
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return  person;
    }
    @RequestMapping("withNameAndAddressNamedQuery")
    public List<Person> test4(String name,String address){
        List<Person> person = personRepository.withNameAndAddressNamedQuery(name, address);
        return  person;
    }
}
