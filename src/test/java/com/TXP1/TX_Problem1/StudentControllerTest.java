package com.TXP1.TX_Problem1;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.TXP1.TX_Problem1.controllers.StudentController;
import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@Import({ClassDetailService.class, StudentService.class})
public class StudentControllerTest {

	@Autowired
	private MockMvc mvc;
    
    @Test
    public void StudentAddedWithoutError()throws Exception {
        String alex = "{\"studentId\": 116, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/students")
        		.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$.studentId",Is.is(116)));
    }
    
    @Test
    public void StudentAddedWithRepeatedStudentId()throws Exception {
        String alex = "{\"studentId\": 111, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/students")
        		.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    }
    
    @Test
    public void CorrectResponseromGetAllStudents() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentId", Is.is(111)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentId", Is.is(112)));;
    
    }
    
    @Test
    public void CorrectResponseFromStudentsPut() throws Exception {
    	String alex = "{\"studentId\": 111, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/students/111")
    			.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentId", Is.is(111)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("Alex")));
    
    }
    
    @Test
    public void StudentsPutNonexistentKey() throws Exception {
    	String alex = "{\"studentId\": 119, \"firstName\" : \"Alex\", \"lastName\" : \"Smith\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/students/119")
    			.content(alex)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    
    }
    
    @Test
    public void CorrectResponseFromStudentsDelete() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/api/students/111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    
    }
    
    @Test
    public void StudentsDeleteNonexistentKey() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/api/students/119")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    
    }
	
}
