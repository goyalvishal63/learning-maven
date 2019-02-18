package com.ericsson.isf.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.isf.model.StudentModel;
import com.ericsson.isf.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/getStudentByRollNo", method = RequestMethod.GET)
	public StudentModel getStudentByRollNo(@RequestParam("rollno") long rollno) throws IOException {
		return studentService.getStudentByRollNo(rollno);
	}
	
	@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	public void saveStudent(StudentModel model) {
		studentService.create(model);
	}
}
