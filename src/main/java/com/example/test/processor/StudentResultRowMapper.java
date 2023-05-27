package com.example.test.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.test.model.Student;

@Component
public class StudentResultRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("StudentResultRowMapper method starttedd");
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setRollNumber(rs.getString("rollnumber"));
        student.setName(rs.getString("name"));
        return student;
	}

}
