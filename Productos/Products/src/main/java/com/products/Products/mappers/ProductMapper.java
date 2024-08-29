package com.products.Products.mappers;

import com.products.Products.dto.ProductDto;
import com.products.Products.dto.ProductToSaveDto;
import com.products.Products.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductDto productEntityToProductDto(Product product);

    @InheritInverseConfiguration
    Product productDtoToProductEntity(ProductDto productDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductToSaveDto productEntityToProductToSaveDto(Product product);

    @InheritInverseConfiguration
    Product productToSaveDtoToProductEntity(ProductToSaveDto productToSaveDto);
}
