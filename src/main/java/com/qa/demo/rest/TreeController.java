package com.qa.demo.rest;


import com.qa.demo.dtos.TreeDTO;
import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import com.qa.demo.services.TreeService;
import com.qa.demo.services.TreeServiceDB;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Spring uses annotations to configure the project
@RestController // it allows Spring to process HTTP requests
@CrossOrigin
public class TreeController {

    private TreeServiceDB service;

    public TreeController(TreeServiceDB service) {
        this.service = service;
    }

    // receives a GET request to /test
    // Responds with text - "Hello, World!"
    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public TreeDTO create(@RequestBody TreeDTO newTree) {
      return this.service.create(newTree);
    }

    @GetMapping("/readAll")
    public List<Tree> read() {
        return this.service.read();
    }

    @GetMapping("/read/{id}")
    public Tree read(@PathVariable("id") int id) {
        return this.service.read(id);
    }

    @GetMapping("/read/type/{type}")
    public List<Tree> read(@PathVariable("type") String type) {
        return this.service.read(TreeType.valueOf(type.toUpperCase()));
    }

    @PatchMapping("/update/{id}")
    public Tree update(@PathVariable("id") int id, @RequestParam(name = "colour", required = false) String colour, @RequestParam(name = "species", required = false) String species, @RequestParam(name = "type", required = false) TreeType type) {
        return this.service.update(id, colour, species, type);
    }

    @DeleteMapping("/delete/{id}")
    public Tree delete(@PathVariable("id") int id) {
        return this.service.delete(id);
    }
}
