package com.qa.demo.services;

import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import com.qa.demo.exceptions.TreeNotFoundException;
import com.qa.demo.repos.TreeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreeServiceDB {


    private TreeRepo repo;

    public TreeServiceDB(TreeRepo repo) {
        this.repo = repo;
    }

    public Tree create(Tree newTree) {
        return this.repo.save(newTree);
    }

    public List<Tree> read() {
        return this.repo.findAll();
    }

    public Tree read(int id) {
//        Optional<Tree> optionalTree = this.repo.findById(id);
//
//        if (optionalTree.isPresent()) {
//            return optionalTree.get();
//        } else {
//            throw new TreeNotFoundException("Tree with id " + id + " not found");
//        }
        return this.repo.findById(id).orElseThrow(TreeNotFoundException::new);
    }

    public List<Tree> read(TreeType type) {
        return this.repo.findByType(type);
    }

    public Tree update(int id, String colour, String species, TreeType type) {
        Tree toUpdate = this.read(id); // fetch out the existing tree from the db

        // change the fields
        if (colour != null) {
            toUpdate.setColour(colour);
        }
        if (species != null) {
            toUpdate.setSpecies(species);
        }
        if (type != null) {
            toUpdate.setType(type);
        }
//        then save it back to the DB (do NOT change the id!)
        return this.repo.save(toUpdate);
    }

    public Tree delete(int id) {
        Tree toRemove = this.read(id);
        this.repo.deleteById(id);
        if (this.repo.existsById(id)) return null;
        else return toRemove;
    }


}
