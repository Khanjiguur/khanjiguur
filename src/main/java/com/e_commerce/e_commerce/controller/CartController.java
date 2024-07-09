package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.CartDTO;
import com.e_commerce.e_commerce.dto.CartDetailDTO;

import com.e_commerce.e_commerce.entity.CartDetail;
import com.e_commerce.e_commerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addToCart(@RequestBody CartDetailDTO cartDetailDTO) {
        cartService.addToCart(cartDetailDTO.getProductId(), cartDetailDTO.getQuantity());
    }

    @PostMapping("/order")
    public void orderCart() {
        cartService.orderCart();
    }
    @GetMapping("/active")
    public CartDTO getActiveCart() {
        return cartService.getActiveCartDTO();
    }



}
