package com.ericsson.isf.service;

import java.io.IOException;
import java.util.List;

import com.ericsson.isf.model.StudentModel;

public interface StudentService {
	public StudentModel getStudentByRollNo(long rollno) throws IOException;
	public void create(StudentModel student);
	public void delete(long rollno);
	public void update(StudentModel Student);
	public List<StudentModel> getAll();
}