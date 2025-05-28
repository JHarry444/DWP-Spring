package com.qa.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "park")
    private List<Tree> trees;

    public Park(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Park(Integer id) {
        this.id = id;
    }

    public Park(String name) {
        this.name = name;
    }

    public Park() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }
}
