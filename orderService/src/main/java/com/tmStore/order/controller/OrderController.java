package com.tmStore.order.controller;

import com.tmStore.common.dto.request.OrderRequest;
import com.tmStore.common.dto.response.ApiResponse;
import com.tmStore.common.dto.response.OrderResponse;
import com.tmStore.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ApiResponse<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        ApiResponse<OrderResponse> apiResponse = new ApiResponse<>(
                true,
                "201",
                "Order created successfully",
                orderResponse
        );
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = orderService.getAllOrders();
        ApiResponse<List<OrderResponse>> apiResponse = new ApiResponse<>(
                true,
                "200",
                "Orders retrieved successfully",
                orders
        );
        return apiResponse;
    }
}

