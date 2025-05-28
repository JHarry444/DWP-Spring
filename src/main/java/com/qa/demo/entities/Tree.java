package com.qa.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "my_park_id") // changes the name of the foreign key column
    private Park park;

    public Tree() {
    }

    public Tree(String species, TreeType type, String colour) {
        this.species = species;
        this.type = type;
        this.colour = colour;
    }

    public Tree(Integer id, String species, TreeType type, String colour) {
        this.id = id;
        this.species = species;
        this.type = type;
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(id, tree.id) && Objects.equals(species, tree.species) && type == tree.type && Objects.equals(colour, tree.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, species, type, colour);
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

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
