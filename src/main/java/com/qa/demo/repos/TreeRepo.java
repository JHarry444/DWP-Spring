package com.qa.demo.repos;

import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeRepo extends JpaRepository<Tree, Integer> {

    // spring will generate the query: SELECT * FROM tree WHERE type = ?
    List<Tree> findByType(TreeType type);
}
