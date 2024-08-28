package com.emazonproject.ms_01_stock.dominio.model;

public class Category {

    private Long id;
    private String name;
    private String description;


    public Category(String description, String name, Long id) {
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
