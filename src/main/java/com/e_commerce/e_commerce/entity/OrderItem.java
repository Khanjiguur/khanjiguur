package com.e_commerce.e_commerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
}