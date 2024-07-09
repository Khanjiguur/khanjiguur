package com.e_commerce.e_commerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDTO {
    private Long productId;
    private String productName;
    private Double quantity;
}
