package com.qa.demo.services;

import com.qa.demo.dtos.ParkDTO;
import com.qa.demo.entities.Park;
import com.qa.demo.exceptions.ParkNotFoundException;
import com.qa.demo.repos.ParkRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkService {


    private ParkRepo repo;

    public ParkService(ParkRepo repo) {
        this.repo = repo;
    }

    public Park create(Park newPark) {
        return this.repo.save(newPark);
    }

    public List<ParkDTO> read() {
        return this.repo.findAll().stream().map(ParkDTO::new).collect(Collectors.toList());
    }

    public Park read(int id) {
//        Optional<Park> optionalPark = this.repo.findById(id);
//
//        if (optionalPark.isPresent()) {
//            return optionalPark.get();
//        } else {
//            throw new ParkNotFoundException("Park with id " + id + " not found");
//        }
        return this.repo.findById(id).orElseThrow(ParkNotFoundException::new);
    }

    public Park update(int id, String name) {
        Park toUpdate = this.read(id); // fetch out the existing park from the db

        // change the fields
        toUpdate.setName(name);
//        then save it back to the DB (do NOT change the id!)
        return this.repo.save(toUpdate);
    }

    public Park delete(int id) {
        Park toRemove = this.read(id);
        this.repo.deleteById(id);
        if (this.repo.existsById(id)) return null;
        else return toRemove;
    }


}
