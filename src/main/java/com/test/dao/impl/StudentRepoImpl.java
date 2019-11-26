package com.test.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.StudentRepo;
import com.test.model.Skills;
import com.test.model.Student;
import com.test.service.StudentService;

@Repository
@Transactional
public class StudentRepoImpl implements StudentRepo {

	@Autowired
	SessionFactory sessionFactory;

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Student create(Student student) {
		// TODO Auto-generated method stub
		currentSession().save(student);
// 		int id = (Integer) currentSession().save(student);
// 		Student st = (Student) currentSession().get(Student.class, id);
// 		st.getSkills().addAll(student.getSkills());
// 		for (Skills skill : student.getSkills()) {
// 			skill.setStudent(st);
// 		}
		return student;
	}

	public Student update(Student student, int id) {
		// TODO Auto-generated method stub
		Student st = find(id);
		for (Skills skill : student.getSkills()) {
			skill.setStudent(st);
		}
		st.getSkills().addAll(student.getSkills());
		currentSession().merge(st);
		return student;

	}

	public Student find(int id) {
		// TODO Auto-generated method stub
		return (Student) currentSession().get(Student.class, id);
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(Student.class).list();
	}

	public Student delete(Student student, int id) {
		currentSession().delete(currentSession().get(Student.class, id));
		return student;
	}

}
