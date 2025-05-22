package com.qa.demo.services;

import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {


    private List<Tree> trees = new ArrayList<>();


    public Tree create(Tree newTree) {
        this.trees.add(newTree);
        return this.trees.getLast();
    }

    public List<Tree> read() {
        return this.trees;
    }

    public Tree read(int id) {
        return this.trees.get(id);
    }

    public Tree update(int id,
                       String colour,
                       String species,
                       TreeType type) {
        Tree toUpdate = this.trees.get(id);
        if (colour != null) {
            toUpdate.setColour(colour);
        }
        if (species != null) {
            toUpdate.setSpecies(species);
        }
        if (type != null) {
            toUpdate.setType(type);
        }

        return toUpdate;
    }

    public Tree delete(int id) {
        return this.trees.remove(id);
    }


}
