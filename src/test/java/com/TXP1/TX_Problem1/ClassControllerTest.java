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

import com.TXP1.TX_Problem1.controllers.ClassController;
import com.TXP1.TX_Problem1.services.ClassDetailService;
import com.TXP1.TX_Problem1.services.ClassService;

@RunWith(SpringRunner.class)
@WebMvcTest(ClassController.class)
@Import({ClassDetailService.class, ClassService.class})
public class ClassControllerTest {

	@Autowired
	private MockMvc mvc;
    
    @Test
    public void ClassAddedWithoutError()throws Exception {
        String musicClass = "{\"code\": 227, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/class")
        		.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code",Is.is(227)));
    }
    
    @Test
    public void ClassAddedWithRepeatedStudentId()throws Exception {
        String musicClass = "{\"code\": 221, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
     
        mvc.perform(MockMvcRequestBuilders.post("/api/class")
        		.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    }
    
    @Test
    public void CorrectResponseFromGetAllClasses() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.get("/api/class")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code", Is.is(221)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].code", Is.is(222)));
    
    }
    
    @Test
    public void CorrectResponseFromClassPut() throws Exception {
    	String musicClass = "{\"code\": 227, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/class/227")
    			.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Is.is(227)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is("Music")));
    
    }
    
    @Test
    public void ClassPutNonexistentKey() throws Exception {
    	String musicClass = "{\"code\": 228, \"title\" : \"Music\", \"description\" : \"Music Class\"}";
    	mvc.perform(MockMvcRequestBuilders.put("/api/class/228")
    			.content(musicClass)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    
    }
    
    @Test
    public void CorrectResponseFromClassDelete() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/api/class/221")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    
    }
    
    @Test
    public void ClassDeleteNonexistentKey() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/api/class/228")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
    
    }
}
