package com.test.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Skills;
import com.test.model.Student;
import com.test.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String register() {
		return "index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Student create(@RequestBody Student student) {
		System.out.println("aaaaaaaaaaaaaaa");
		Student response = studentService.create(student);
		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<Student> getAllStudent() {
		List<Student> list = studentService.getAllStudent();
		Set<Student> response = new HashSet<Student>(list);
		System.out.println("result" + response.toString());
		return response;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Student editStudent(@PathVariable("id") int id, @RequestBody Student student) {
		System.out.println("id" + id);
		Student response = studentService.update(student, id);
		return response;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Student deleteStudent(@PathVariable("id") int id, Student student) {
		Student response = studentService.delete(student, id);
		return response;
	}
}
