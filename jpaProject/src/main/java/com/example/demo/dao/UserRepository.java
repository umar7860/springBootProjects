package com.example.demo.dao;

import com.example.demo.dataClass.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  UserRepository extends CrudRepository<User,Integer> {

public List<User> findByName(String name);
public List<User> findByNameAndCity(String name,String city);

public List<User> findByNameStartingWith(String prefix);
public List<User> findByNameEndingWith(String suffix);
public List<User> findByNameContaining(String words);


// we will use @Query annoatation for writing custom queries
    //JPQL  -->> Java Presistence Query Language
    //Native SQL query

    @Query("select u from User u")
    public List<User> getAllUser();

    //Parametrized Query
    @Query("select u from User u where u.name =:n ")
    public List<User> getUserByName(@Param("n") String name);

    @Query("select u from User u where u.name =:n and u.city =:c")
    public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);

    //Native Query

    @Query(value = "select * from user",nativeQuery = true)
    public List<User> getUsers();

}
