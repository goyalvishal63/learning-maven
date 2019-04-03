package com.ericsson.isf.mapper;

import org.apache.ibatis.annotations.Param;

import com.ericsson.isf.model.StudentModel;

public interface StudentMapper {
	public StudentModel getStudentByRollNo(@Param("rollno")Long rollno);
	public void saveStudent(@Param("studentData")StudentModel student);
}
