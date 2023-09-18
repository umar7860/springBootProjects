package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Create the Table
    public void createTable() {
        var query = "CREATE Table student(id SERIAL PRIMARY KEY, name varchar(255) NOT NULL,city varchar(255))";
        int update = this.jdbcTemplate.update(query);
        System.out.println(update);
    }
    //INserting data
    public void insertData(String name,String city) {
        var q = "INSERT INTO student (name,city) values(?,?)";
        int v = this.jdbcTemplate.update(q,name,city);
        System.out.println(v);
    }
}
