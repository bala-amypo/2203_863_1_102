package com.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private String brand;
    private String modelNumber;
    private String category;
}
