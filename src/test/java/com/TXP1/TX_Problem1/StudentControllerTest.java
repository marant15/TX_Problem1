package com.TXP1.TX_Problem1;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.TXP1.TX_Problem1.controllers.StudentController;
import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.ClassService;
import com.TXP1.TX_Problem1.services.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	@MockBean
	private StudentService studentService;
	
	@MockBean
	private ClassService classService;
	
	@MockBean
	private ClassDetailService classDetailService;
	
	@Autowired
	StudentController studentController;

	@Autowired
	private MockMvc mvc;
    
    @Test
    public void StudentAddedWithoutError()throws Exception {
        String alex = "{\"studentId\": 116, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/students")
        		.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void CorrectResponseromGetAllStudents() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    
    }
    
    @Test
    public void CorreResponseFromStudentsPut() throws Exception {
    	String alex = "{\"studentId\": 111, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/students/111")
    			.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    
    }
	
}
