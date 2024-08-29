package com.products.Products.mappers;

import com.products.Products.dto.ProductDto;
import com.products.Products.dto.ProductToSaveDto;
import com.products.Products.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T20:53:52-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productEntityToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        Double price = null;
        Integer stock = null;

        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        stock = product.getStock();

        ProductDto productDto = new ProductDto( id, name, description, price, stock );

        return productDto;
    }

    @Override
    public Product productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productDto.id() );
        product.name( productDto.name() );
        product.description( productDto.description() );
        product.price( productDto.price() );
        product.stock( productDto.stock() );

        return product.build();
    }

    @Override
    public ProductToSaveDto productEntityToProductToSaveDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        Double price = null;
        Integer stock = null;

        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        stock = product.getStock();

        ProductToSaveDto productToSaveDto = new ProductToSaveDto( id, name, description, price, stock );

        return productToSaveDto;
    }

    @Override
    public Product productToSaveDtoToProductEntity(ProductToSaveDto productToSaveDto) {
        if ( productToSaveDto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productToSaveDto.id() );
        product.name( productToSaveDto.name() );
        product.description( productToSaveDto.description() );
        product.price( productToSaveDto.price() );
        product.stock( productToSaveDto.stock() );

        return product.build();
    }
}
