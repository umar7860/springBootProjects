package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImplemention implements StudentDao {

	private JdbcTemplate jdbcTempelate;

	@Override
	public int insert(Student student) {
		// Insert Query
		String query = "Insert into student(id,name,city) values(?,?,?)";

		// fire the query
		int result = this.jdbcTempelate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public JdbcTemplate getJdbcTempelate() {
		return jdbcTempelate;
	}

	public void setJdbcTempelate(JdbcTemplate jdbcTempelate) {
		this.jdbcTempelate = jdbcTempelate;
	}

	@Override
	public int update(Student student) {
		String query = "Update student set name=?, city=? where id=?";
		int update = this.jdbcTempelate.update(query,student.getName(),student.getCity(),student.getId());
		return update;
	}

	@Override
	public int delete(int studentId) {
		// delete
		String query = "Delete from student where id=?";
		int deleteRecord = this.jdbcTempelate.update(query,studentId);
		return deleteRecord;
	}

	@Override
	public Student getStudentObject(int studentId) {
		String query = "Select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student =this.jdbcTempelate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> getListOfStudents() {
		String query = "Select * from student";
		List<Student> students =  this.jdbcTempelate.query(query, new RowMapperImpl());
		return students;
	}

}
