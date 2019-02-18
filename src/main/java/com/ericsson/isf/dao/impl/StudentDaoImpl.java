package com.ericsson.isf.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import com.ericsson.isf.dao.StudentDao;
import com.ericsson.isf.mapper.StudentMapper;
import com.ericsson.isf.model.StudentModel;;

@Repository
public class StudentDaoImpl implements StudentDao{
	
		
	@Override
	public StudentModel getStudentByRollNo(long rollno) throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    SqlSession session = sqlSessionFactory.openSession();
	    StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.getStudentByRollNo(rollno);
	}

	@Override
	public void create(StudentModel student) {
		
	}

	@Override
	public void delete(long rollno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentModel Student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
