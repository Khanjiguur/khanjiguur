package com.e_commerce.e_commerce.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isOrdered;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;
}
