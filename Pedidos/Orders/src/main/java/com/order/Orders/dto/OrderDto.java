package com.order.Orders.dto;

import com.order.Orders.entity.OrderState;

public record OrderDto(
        Long id,
        Long userID,
        Long productID,
        Integer quantity,
        OrderState status
) {
}
