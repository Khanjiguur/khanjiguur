package com.e_commerce.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_images")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId;

    private String imageUrl;

    private Long productId;


}