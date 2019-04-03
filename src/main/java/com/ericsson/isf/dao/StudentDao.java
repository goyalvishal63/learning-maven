package com.ericsson.isf.dao;

import java.io.IOException;
import java.util.List;

import com.ericsson.isf.model.StudentModel;

public interface StudentDao {
	public StudentModel getStudentByRollNo(long rollno) throws IOException;
	public void create(StudentModel student) throws IOException;
	public void delete(long rollno);
	public void update(StudentModel Student);
	public List<StudentModel> getAll();
}
