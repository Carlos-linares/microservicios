package com.ordersPackage.Orders.dto;

import com.order.Orders.entity.OrderState;

public record OrderToSaveDto(
        Long id,
        Long userID,
        Long productID,
        Integer quantity,
        OrderState status
) {
}
