package com.qa.demo.dtos;

import com.qa.demo.entities.Park;

import java.util.List;
import java.util.stream.Collectors;

public class ParkDTO {

    private Integer id;
    private String name;
    private List<TreeDTO> trees;

    public ParkDTO() {
    }

    public ParkDTO(Park park) {
        this.id = park.getId();
        this.name = park.getName();
        this.trees = park.getTrees().stream().map(TreeDTO::new).collect(Collectors.toList());
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

    public List<TreeDTO> getTrees() {
        return trees;
    }

    public void setTrees(List<TreeDTO> trees) {
        this.trees = trees;
    }
}
