package com.qa.demo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// tells Spring to boot the server for testing
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the 'mock' requests
public class TreeIntegrationTest {

    @Autowired//ask me later
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception{

        Tree newTree = new Tree("Chestnut", TreeType.DECIDUOUS, "Brown");
        String newTreeAsJSON = this.mapper.writeValueAsString(newTree);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/create")
                .content(newTreeAsJSON)
                .contentType(MediaType.APPLICATION_JSON);


        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Tree createdTree = new Tree("Chestnut", TreeType.DECIDUOUS, "Brown");
        createdTree.setId(1);
        String createdTreeAsJSON = this.mapper.writeValueAsString(createdTree);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdTreeAsJSON);

        this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
    }
}
