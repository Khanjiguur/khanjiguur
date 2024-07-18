package com.e_commerce.e_commerce.repository;

import com.e_commerce.e_commerce.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
