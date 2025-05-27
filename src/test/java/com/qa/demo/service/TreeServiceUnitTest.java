package com.qa.demo.service;

import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import com.qa.demo.repos.TreeRepo;
import com.qa.demo.services.TreeService;
import com.qa.demo.services.TreeServiceDB;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TreeServiceUnitTest {

    @Autowired
    private TreeServiceDB service;

    @MockitoBean
    private TreeRepo repo;


    @Test
    void testUpdate() {
        // only works if Tree has a .equals() method generated
        final Integer id = 1;
        Mockito
                .when(repo.findById(id))
                .thenReturn(Optional.of(new Tree(id, "Birch", TreeType.DECIDUOUS, "Brown")));

        final Tree updatedTree = new Tree(id, "Birch", TreeType.EVERGREEN, "Brown");
        Mockito.when(this.repo.save(updatedTree))
                .thenReturn(updatedTree);
        assertEquals(updatedTree,
                this.service.update(1, null, null, TreeType.EVERGREEN));
    }
}
