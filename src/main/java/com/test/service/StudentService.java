package com.test.service;

import java.util.List;

import com.test.model.Student;

public interface StudentService {
	Student create(Student student);
	Student update(Student student,int id);
	Student delete(Student student,int id);
	Student find(int id);
	List<Student>getAllStudent();

}
