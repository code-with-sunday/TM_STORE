package com.tmStore.order.service;

import com.tmStore.common.dto.request.OrderRequest;
import com.tmStore.common.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);
    List<OrderResponse> getAllOrders();
}
