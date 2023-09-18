package com.example.demo;

import com.example.demo.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SpringBootjdbcApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootjdbcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTableFunction());
		//Now creating user.....
		this.createUser();

	}

	public void createUser() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter user id:");
			int userId = Integer.parseInt(br.readLine());

			System.out.println("Enter user name:");
			String userName = br.readLine();


			System.out.println("Enter user city:");
			String userCity = br.readLine();


			System.out.println("Enter user age:");
			int userAge = Integer.parseInt(br.readLine());

			int i = this.userDao.insertData(userId,userName,userAge,userCity);
			System.out.println(i+ " User Added....");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
