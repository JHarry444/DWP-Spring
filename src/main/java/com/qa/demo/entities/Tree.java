package com.qa.demo.entities;

import jakarta.persistence.*;

@Entity
public class Tree {


    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer id;
    @Column(name = "UniqueSpecies", nullable = false, unique = true) // NOT NULL and UNIQUE
    private String species;
    @Enumerated(EnumType.STRING) // tells spring this is an enum type
    private TreeType type;
    private String colour;

    public Tree() {
    }

    public Tree(String species, TreeType type, String colour) {
        this.species = species;
        this.type = type;
        this.colour = colour;
    }

    //  DON'T FORGET THE GETTERS AND SETTERS
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
}
