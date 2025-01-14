package com.tmStore.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "order")
public class Order extends BaseEntity{

    private int quantity;

    private BigDecimal totalPrice;

    private String product;
}
