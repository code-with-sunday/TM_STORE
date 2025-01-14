package com.tmStore.order.service.serviceImpl;

import com.tmStore.common.dto.request.OrderRequest;
import com.tmStore.common.dto.response.OrderResponse;
import com.tmStore.order.entity.Order;
import com.tmStore.order.mapper.OrderMapper;
import com.tmStore.order.repository.OrderRepository;
import com.tmStore.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceOrderImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }
}
