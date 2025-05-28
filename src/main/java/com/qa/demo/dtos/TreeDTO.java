package com.qa.demo.dtos;

import com.qa.demo.entities.Tree;
import com.qa.demo.entities.TreeType;

public class TreeDTO {

    private Integer id;
    private String species;
    private TreeType type;
    private String colour;
    private Integer parkId;

    public TreeDTO() {
    }

    public TreeDTO(Tree tree) {
        this.id = tree.getId();
        this.species = tree.getSpecies();
        this.type = tree.getType();
        this.colour = tree.getColour();
        this.parkId = tree.getPark().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }
}
