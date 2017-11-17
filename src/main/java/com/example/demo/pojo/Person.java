package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
        query = "SELECT P FROM Person P WHERE P.name = ?1 AND P.address = ?2")
public class Person {
    @Id//id列
    @GeneratedValue//自增
    //id
    private long id;
    //姓名
    private String name;
    //地址
    private String address;
    //年龄
    private int age;

    public Person() {
    }

    public Person(Long id , String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
