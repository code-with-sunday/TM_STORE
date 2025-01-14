package com.tmStore.client;

import com.tmStore.common.dto.request.OrderRequest;
import com.tmStore.common.dto.response.ApiResponse;
import com.tmStore.common.dto.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "order")
public interface OrderClient {

    @PostMapping
    ApiResponse<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping
    ApiResponse<List<OrderResponse>> getAllOrders();
}
