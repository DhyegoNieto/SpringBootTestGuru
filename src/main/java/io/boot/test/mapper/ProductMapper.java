package io.boot.test.mapper;

import io.boot.test.model.Product;
import io.boot.test.model.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto entityToDto(Product entity);

    Product dtoToEntity(ProductDto dto);
}
