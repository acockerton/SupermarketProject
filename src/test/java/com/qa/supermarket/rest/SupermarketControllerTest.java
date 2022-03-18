package com.qa.supermarket.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.supermarket.domain.Supermarket;

@SpringBootTest
@AutoConfigureMockMvc 
@Sql(scripts = {"classpath:supermarket-schema.sql","classpath:supermarket-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SupermarketControllerTest {

@Autowired
private MockMvc mock; 

@Autowired
private ObjectMapper map; 

@Test
void testCreate() throws Exception {

	Supermarket create = new Supermarket("Peas",500,"Frozen");
	
	String createJSON =this.map.writeValueAsString(create);
	
	RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);
	
	Supermarket saved = new Supermarket(1L, "Peas",500,"Frozen");
	
	String savedJSON =this.map.writeValueAsString(saved);
	
	ResultMatcher matchStatus = status().isCreated();

	ResultMatcher matchBody = content().json(savedJSON);

	this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	
}

@Test
void testRemove() throws Exception {
	Long id = 1L;
	RequestBuilder mockRequest = delete("/remove/?id="+id);
	ResultMatcher status = status().isOk();
	ResultMatcher body = content().string("true");
	this.mock.perform(mockRequest).andExpect(body).andExpect(status);
}



}
