package com.qa.demo.rest;


import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import com.qa.demo.services.TreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Spring uses annotations to configure the project
@RestController // it allows Spring to process HTTP requests
public class TreeController {

    private TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    // receives a GET request to /test
    // Responds with text - "Hello, World!"
    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Tree create(@RequestBody Tree newTree) {
      return this.treeService.create(newTree);

    }

    @GetMapping("/readAll")
    public List<Tree> read() {
        return this.treeService.read();
    }

    @GetMapping("/read/{id}")
    public Tree read(@PathVariable("id") int id) {
        return this.treeService.read(id);
    }

    @PatchMapping("/update/{id}")
    public Tree update(@PathVariable("id") int id, @RequestParam(name = "colour", required = false) String colour, @RequestParam(name = "species", required = false) String species, @RequestParam(name = "type", required = false) TreeType type) {
        return this.treeService.update(id, colour, species, type);
    }

    @DeleteMapping("/delete/{id}")
    public Tree delete(@PathVariable("id") int id) {
        return this.treeService.delete(id);
    }
}
