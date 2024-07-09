package com.e_commerce.e_commerce.repository;

import com.e_commerce.e_commerce.entity.Cart;
import com.e_commerce.e_commerce.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    
}
