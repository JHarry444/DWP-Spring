package com.qa.demo.rest;


import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Spring uses annotations to configure the project
@RestController // it allows Spring to process HTTP requests
public class TreeController {

    private List<Tree> trees = new ArrayList<>();

    // receives a GET request to /test
    // Responds with text - "Hello, World!"
    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Tree create(@RequestBody Tree newTree) {
        this.trees.add(newTree);
        return this.trees.getLast();
    }

    @GetMapping("/readAll")
    public List<Tree> read() {
        return this.trees;
    }

    @GetMapping("/read/{id}")
    public Tree read(@PathVariable("id") int id) {
        return this.trees.get(id);
    }

    @PatchMapping("/update/{id}")
    public Tree update(@PathVariable("id") int id,
                       @RequestParam(name = "colour", required = false) String colour,
                       @RequestParam(name = "species", required = false) String species,
                       @RequestParam(name = "type", required = false) TreeType type) {
        Tree toUpdate = this.trees.get(id);
        if (colour != null) {
            toUpdate.setColour(colour);
        }
        if(species != null) {
            toUpdate.setSpecies(species);
        }
        if (type != null) {
            toUpdate.setType(type);
        }

        return toUpdate;
    }

    @DeleteMapping("/delete/{id}")
    public Tree delete(@PathVariable("id") int id) {
        return this.trees.remove(id);
    }
}
