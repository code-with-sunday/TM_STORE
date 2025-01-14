package com.tmStore.order.mapper;

import com.tmStore.common.dto.request.OrderRequest;
import com.tmStore.common.dto.response.OrderResponse;
import com.tmStore.order.entity.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .product(order.getProduct())
                .build();
    }

    public Order toEntity(OrderRequest orderRequest) {
        return Order.builder()
                .quantity(orderRequest.getQuantity())
                .product(orderRequest.getProduct())
                .totalPrice(calculateTotalPrice(orderRequest.getQuantity()))
                .build();
    }

    private BigDecimal calculateTotalPrice(int quantity) {
        return BigDecimal.valueOf(quantity * 10);
    }
}

