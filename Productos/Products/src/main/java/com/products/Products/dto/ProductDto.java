package com.products.Products.dto;

public record ProductDto(
        Long id,
        String name,
        String description,
        Double price,
        Integer stock
) {
}
