package com.ericsson.isf.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.isf.dao.StudentDao;
import com.ericsson.isf.model.StudentModel;
import com.ericsson.isf.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao StudentDao;

	@Override
	public StudentModel getStudentByRollNo(long rollno) throws IOException {
		return StudentDao.getStudentByRollNo(rollno);
	}

	@Override
	public void create(StudentModel student) throws IOException {
		StudentDao.create(student);
	}

	@Override
	public void delete(long rollno) {
		StudentDao.delete(rollno);
	}

	@Override
	public void update(StudentModel Student) {
		StudentDao.update(Student);
	}

	@Override
	public List<StudentModel> getAll() {
		return StudentDao.getAll();
	}

}
