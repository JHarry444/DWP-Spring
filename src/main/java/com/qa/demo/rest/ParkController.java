package com.qa.demo.rest;


import com.qa.demo.dtos.ParkDTO;
import com.qa.demo.entities.Park;
import com.qa.demo.services.ParkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Spring uses annotations to configure the project
@RestController // it allows Spring to process HTTP requests
@RequestMapping("/park") // prepends to all of the mappings underneath
public class ParkController {

    private ParkService service;

    public ParkController(ParkService service) {
        this.service = service;
    }

    // receives a GET request to /test
    // Responds with text - "Hello, World!"
    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Park create(@RequestBody Park newPark) {
      return this.service.create(newPark);
    }

    @GetMapping("/readAll")
    public List<ParkDTO> read() {
        return this.service.read();
    }

    @GetMapping("/read/{id}")
    public Park read(@PathVariable("id") int id) {
        return this.service.read(id);
    }

    @PatchMapping("/update/{id}")
    public Park update(@PathVariable("id") int id,
                       @RequestParam(name = "name") String name) {
        return this.service.update(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public Park delete(@PathVariable("id") int id) {
        return this.service.delete(id);
    }
}
