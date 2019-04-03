package com.ericsson.isf.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ericsson.isf.controller.StudentController;
import com.ericsson.isf.model.StudentModel;
import com.ericsson.isf.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration("classpath*:dispatcher-servlet.xml")
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StudentService studentService;

	//StudentModel mockStudent = new StudentModel(1,"ABC","abc@xyz.com","Computer Science");

	String exampleCourseJson = "{\"rollno\":\"6\",\"name\":\"pqr\",\"email\":\"pqr@xyz.com\",\"stream\":\"Chemical\"}";

	@Test
	public void testStudentController() throws Exception {

		//Mockito.when(studentService.getStudentByRollNo(Mockito.anyLong())).thenReturn(mockStudent);
		/*
		 * RequestBuilder requestBuilder =
		 * MockMvcRequestBuilders.get("/getStudentByRollNo?rollno=2")
		 * .accept(MediaType.APPLICATION_JSON);
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 */
		StudentModel actual = studentService.getStudentByRollNo(1);

		System.out.println(actual);
		String actjson = new ObjectMapper().writeValueAsString(actual);
		String expected = "{rollNumber:1,name:ABC,email:abc@xyz.com}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, actjson, false);
	}
	
	@Test
	public void createStudentCourse() throws Exception {
		//Mockito.when(studentService.create(Mockito.any(StudentModel.class))).thenReturn(mockStudent);
		
		//Mockito.doNothing().when(studentService).create(Mockito.any(StudentModel.class));

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/saveStudent")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
}