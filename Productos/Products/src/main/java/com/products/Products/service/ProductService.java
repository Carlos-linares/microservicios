package com.products.Products.service;

import com.products.Products.dto.ProductDto;
import com.products.Products.dto.ProductToSaveDto;
import com.products.Products.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDto saveProducto(ProductToSaveDto productToSaveDto);
    ProductDto findById(Long id) throws ProductNotFoundException;
    List<ProductDto> findByNameAndPrice(String name, float price) throws ProductNotFoundException;
    ProductDto updateProductoById(Long id, ProductToSaveDto productToSaveDto) throws ProductNotFoundException;
    void deleteProductoById(Long id);
    List<ProductDto> findProductoByNombre(String name);

}
