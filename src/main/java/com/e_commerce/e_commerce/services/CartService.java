package com.e_commerce.e_commerce.services;

import com.e_commerce.e_commerce.dto.CartDTO;
import com.e_commerce.e_commerce.dto.CartDetailDTO;
import com.e_commerce.e_commerce.entity.Cart;
import com.e_commerce.e_commerce.entity.CartDetail;
import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.repository.CartDetailRepository;
import com.e_commerce.e_commerce.repository.CartRepository;
import com.e_commerce.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getActiveCart() {
        Cart cart = cartRepository.findByIsOrderedFalse();
        if (cart == null) {
            cart = new Cart();
            cart.setOrdered(false);
            cartRepository.save(cart);
        }
        return cart;
    }

    public void addToCart(Long productId, Double quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Cart cart = getActiveCart();

        CartDetail cartDetail = new CartDetail();
        cartDetail.setProduct(product);
        cartDetail.setQuantity(quantity);
        cartDetail.setCart(cart);
        cartDetailRepository.save(cartDetail);
    }

    public void deleteCartItem(Long productId){
        cartDetailRepository.deleteById(productId);
    }



    public void orderCart() {
        Cart cart = getActiveCart();
        cart.setOrdered(true);
        cartRepository.save(cart);
    }

    public CartDTO getActiveCartDTO() {
        Cart cart = getActiveCart();
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setOrdered(cart.isOrdered());

        List<CartDetailDTO> cartDetailDTOs = cart.getCartDetails().stream()
                .map(cartDetail -> {
                    CartDetailDTO cartDetailDTO = new CartDetailDTO();
                    cartDetailDTO.setProductId(cartDetail.getProduct().getId());
                    cartDetailDTO.setProductName(cartDetail.getProduct().getName());
                    cartDetailDTO.setQuantity(cartDetail.getQuantity());
                    return cartDetailDTO;
                })
                .collect(Collectors.toList());

        cartDTO.setCartDetails(cartDetailDTOs);
        return cartDTO;
    }
}
