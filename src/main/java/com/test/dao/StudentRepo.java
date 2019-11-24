package com.test.dao;

import java.util.List;

import com.test.model.Student;

public interface StudentRepo {

	Student create(Student student);
	Student update(Student student,int id);
	Student delete(Student student,int id);
	Student find(int id);
	List<Student>getAllStudent();
}
