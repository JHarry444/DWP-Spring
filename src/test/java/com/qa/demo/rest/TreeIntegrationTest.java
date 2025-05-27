package com.qa.demo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// tells Spring to boot the server for testing
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the 'mock' requests
@Sql(scripts = {"classpath:tree-schema.sql", "classpath:tree-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class TreeIntegrationTest {

    @Autowired//ask me later
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void testGet() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/readAll");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Tree[] testTrees = {new Tree(1, "Fir", TreeType.EVERGREEN, "green")};
        ResultMatcher checkBody = MockMvcResultMatchers.content()
                .json(this.mapper.writeValueAsString(testTrees));

        this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGetByID() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/read/1");

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Tree testTree = new Tree(1, "Fir", TreeType.EVERGREEN, "green");
        ResultMatcher checkBody = MockMvcResultMatchers.content()
                .json(this.mapper.writeValueAsString(testTree));

        this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreate() throws Exception {

        Tree newTree = new Tree("Chestnut", TreeType.DECIDUOUS, "Brown");
        String newTreeAsJSON = this.mapper.writeValueAsString(newTree);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/create")
                .content(newTreeAsJSON)
                .contentType(MediaType.APPLICATION_JSON);


        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Tree createdTree = new Tree("Chestnut", TreeType.DECIDUOUS, "Brown");
        createdTree.setId(2);
        String createdTreeAsJSON = this.mapper.writeValueAsString(createdTree);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdTreeAsJSON);

        this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
    }
}
