package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("My program started");
		// spring jdbc ==> jdbcTemplate

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// Inserting

//		Student student = new Student(2355, "Faiz", "Kotli");
//		
//		int result = studentDao.insert(student);
//		System.out.println("Record added...."+ result);

		// Updating
//		Student updateStudent = new Student(231, "Saleh", "Samror");
//		int result = studentDao.update(updateStudent);
//		System.out.println("Record added...." + result);

		// Deleting the records...
//		int result = studentDao.delete(231);
//		System.out.println("Record Deleted...."+result);

		// Getting data from database..

//		Student student = studentDao.getStudentObject(222);
//		System.out.println(student);

		// Getting all the students

		List<Student> students = studentDao.getListOfStudents();
		// Printing all the students

		for (Student student : students) {
			System.out.println(student);
		}

	}
}
