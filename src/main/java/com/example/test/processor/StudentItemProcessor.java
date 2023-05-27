package com.example.test.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.test.model.Student;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {

	 @Override
	    public Student process(Student student) throws Exception {
	    	System.out.println("processor inside the method  starttedd");
	        return student;
	    }
}
