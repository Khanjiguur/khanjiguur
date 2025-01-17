package com.e_commerce.e_commerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {


    private Long id;
    private boolean isOrdered;
    private List<CartDetailDTO> cartDetails;

}
