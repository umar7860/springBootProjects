package com.example.demo.userDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserDao () {
    }


    //For creating table
    public int createTableFunction() {
        String query = "CREATE TABLE IF NOT EXISTS User(id int primary key,name varchar(200),Age int,city varchar(100))";
        int update = this.jdbcTemplate.update(query);
        return update;
    }

    //Inserting data to user table

    public  int insertData(int id,String name,int age,String city) {
        String query = "Insert INTO USER(id,name,age,city) values(?,?,?,?)";
        int update = this.jdbcTemplate.update(query,new Object[]{id,name,age,city});
        return update;
    }
}
