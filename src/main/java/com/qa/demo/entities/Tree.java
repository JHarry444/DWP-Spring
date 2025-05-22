package com.qa.demo.entities;

public class Tree {


    private String species;
    private TreeType type;
    private String colour;

    public Tree() {
    }

    public Tree(String species, TreeType type, String colour) {
        this.species = species;
        this.type = type;
        this.colour = colour;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public TreeType getType() {
        return type;
    }

    public void setType(TreeType type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
