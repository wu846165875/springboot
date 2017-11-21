package com.example.demo.hibernate.repositoryinter;

import com.example.demo.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long>{
    @Override
    List<Person> findAll();


    Person findByName(String name);

    @Query("SELECT P FROM Person P WHERE P.name = :name AND P.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name,@Param("address") String address);

    List<Person> withNameAndAddressNamedQuery(String name,String address);

    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}
