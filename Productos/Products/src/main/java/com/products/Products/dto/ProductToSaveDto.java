package com.products.Products.dto;

public record ProductToSaveDto(
        Long id,
        String name,
        String description,
        Double price,
        Integer stock
) {
}
