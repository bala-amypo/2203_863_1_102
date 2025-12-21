package com.example.demo.entity;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String modelNumber;  // Add this field
    private String category;     // Add this field

    // Existing getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // New getters and setters for modelNumber and category
    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
