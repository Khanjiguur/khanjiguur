package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.CartDTO;
import com.e_commerce.e_commerce.dto.OrderDTO;
import com.e_commerce.e_commerce.entity.Order;
import com.e_commerce.e_commerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/active")
    public CartDTO getActiveCart() {
        return cartService.getActiveCartDTO();
    }

    @GetMapping("/add")
    public void addToCart(@RequestParam Long productId, @RequestParam Double quantity) {
        cartService.addToCart(productId, quantity);
    }


    @PostMapping("/order")
    public ResponseEntity<Order> orderCart(@RequestBody OrderDTO orderDTO) {
        try {
            cartService.orderCart(orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/item/{productId}")
    public void deleteCartItem(@PathVariable Long productId) {
        cartService.deleteCartItem(productId);
    }
}
