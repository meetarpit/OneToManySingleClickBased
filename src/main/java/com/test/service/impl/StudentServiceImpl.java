package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.StudentRepo;
import com.test.model.Student;
import com.test.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	public Student create(Student student) {
		// TODO Auto-generated method stub
		studentRepo.create(student);
		return student;
	}

	public Student update(Student student,int id) {
		// TODO Auto-generated method stub
		studentRepo.update(student,id);
		return student;
	}

	public Student delete(Student student,int id) {
		// TODO Auto-generated method stub
		studentRepo.delete(student,id);
		return student;
	}

	public Student find(int id) {
		// TODO Auto-generated method stub
		return studentRepo.find(id);
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.getAllStudent();
	}

	
}
