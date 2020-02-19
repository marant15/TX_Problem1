package com.TXP1.TX_Problem1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.TXP1.TX_Problem1.controllers.ClassController;
import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.ClassService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClassController.class)
public class ClassControllerTest {
	
	@MockBean
	private ClassService classService;
	
	@MockBean
	private ClassDetailService classDetailService;

	@Autowired
	private MockMvc mvc;
    
    @Test
    public void StudentAddedWithoutError()throws Exception {
        String musicClass = "{\"code\": 227, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/class")
        		.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
    
    @Test
    public void CorrectResponseromGetAllStudents() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/api/class")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    
    }
    
    @Test
    public void CorrectResponseFromStudentsPut() throws Exception {
    	String musicClass = "{\"code\": 227, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/class/221")
    			.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    
    }
    
    @Test
    public void CorrectResponseFromStudentsDelete() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/api/class/221")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    
    }
}
