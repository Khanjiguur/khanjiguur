package com.e_commerce.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Double price;
    private String category;
    private String description;
    private Double rating;
    private String color;
    private List<ProductImagesDTO> images;
}